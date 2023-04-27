package xyz.oiio.nightwatch.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import xyz.oiio.nightwatch.converter.LocalDateTimeConverter;
import xyz.oiio.nightwatch.model.LogInfo;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@Setter
@Slf4j
@Document(indexName = "gateway-logs")
public class LogEntity {

    @Id
    private String id;

//    private LogInfo info;

    @Field(name = "@timestamp", type = FieldType.Date)
    private LocalDateTime timestamp;

    private String message;

    private String thread_name;

    private String level;

    private String logger_name;
}
