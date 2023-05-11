package xyz.oiio.nightwatch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import xyz.oiio.nightwatch.entity.LogEntity;

import java.util.List;


@Repository
public interface LogRepository extends ElasticsearchRepository<LogEntity, String> {
    Page<LogEntity> findAllByOrderByCreateAtDesc(Pageable pageable);

    Page<LogEntity> findByMessageLike(String words, Pageable pageable);

    Page<LogEntity> findByMessageContains(String words, Pageable pageable);

    Page<LogEntity> findByMessageStartingWith(String words, Pageable pageable);
}
