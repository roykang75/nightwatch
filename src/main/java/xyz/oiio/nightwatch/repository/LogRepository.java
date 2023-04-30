package xyz.oiio.nightwatch.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import xyz.oiio.nightwatch.entity.LogEntity;

import java.util.List;


@Repository
public interface LogRepository extends ElasticsearchRepository<LogEntity, String> {
    List<LogEntity> findAllByOrderByCreateAtDesc(Pageable pageable);
}
