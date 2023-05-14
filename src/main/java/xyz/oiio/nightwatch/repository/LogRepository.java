package xyz.oiio.nightwatch.repository;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.oiio.nightwatch.entity.LogEntity;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface LogRepository extends ElasticsearchRepository<LogEntity, String> {
//    Page<LogEntity> findAllByOrderByCreateAtDesc(Pageable pageable);
//
//    Page<LogEntity> findByMessageLike(String words, Pageable pageable);
//
//    Page<LogEntity> findByMessageContains(String words, Pageable pageable);
//
//    List<LogEntity> findByMessageContains(String words);
//
//    Page<LogEntity> findByMessageStartingWith(String words, Pageable pageable);

    Page<LogEntity> findByCreateAtBetween(LocalDateTime startDateTime, LocalDateTime endDateTime, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"message\" : \":phrase\"}}}}")
    Page<LogEntity> findByMessage(@Param("message") String phrase, Pageable pageable);
}
