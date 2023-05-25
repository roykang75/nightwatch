package xyz.oiio.nightwatch.config;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "xyz.oiio.nightwatch.repository")
@ComponentScan(basePackages = { "xyz.oiio.nightwatch.service" })
@Slf4j
public class ElasticSearchConfig {

	@Value("${es.usingSsl}")
	private boolean usingSsl;

	@Value("${es.url}")
	private String baseURL;

	@Bean
	public RestHighLevelClient client() {
		log.info("### usingSsl: {}", usingSsl);
		ClientConfiguration configuration = null;
		long timeout = 60 * 1000;

		if (usingSsl) {
			configuration = ClientConfiguration.builder().connectedTo(baseURL).usingSsl().build();
		} else {
			configuration = ClientConfiguration.builder().connectedTo(baseURL).withConnectTimeout(timeout)
//					.withBasicAuth("elastic", "kN8fRCJ3isi9JjAtD1CY")
					.withSocketTimeout(timeout).build();
		}

		return RestClients.create(configuration).rest();
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(client());
	}
}