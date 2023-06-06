package xyz.oiio.nightwatch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.oiio.nightwatch.entity.LogEntity;
import xyz.oiio.nightwatch.repository.LogRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LogService {
    private final LogRepository logRepository;

    @Transactional(readOnly = true)
    public List<LogEntity> findAll() {
        return logRepository.findAll(PageRequest.of(0, 100)).toList();
    }

//    @Transactional(readOnly = true)
//    public Page<LogEntity> findAllByOrderByCreateAtDesc() {
//        Pageable pageable = Pageable.ofSize(1000).withPage(1);
//        return logRepository.findAllByOrderByCreateAtDesc(pageable);
//    }
//
//    @Transactional(readOnly = true)
//    public Page<LogEntity> CreateAtDescByPaging(int perPage, int perSize) {
//        Pageable pageable = PageRequest.of(perPage - 1, perSize, Sort.Direction.DESC, "createAt");
//        return logRepository.findAllByOrderByCreateAtDesc(pageable);
//    }
//
//    @Transactional(readOnly = true)
//    public Page<LogEntity> MessageLikeByPaging(int pageNumber, int pageSize, String words) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.DESC, "createAt");
//        String searchWords = "%" + words.trim() + "%";
//        return logRepository.findByMessageLike(searchWords, pageable);
//    }
//
//    @Transactional(readOnly = true)
//    public Page<LogEntity> MessageContainsByPaging(int pageNumber, int pageSize, String words) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.DESC, "createAt");
//        String searchWords = words.trim();
//        return logRepository.findByMessageContains(searchWords, pageable);
//    }
//
//    @Transactional(readOnly = true)
//    public Page<LogEntity> MessageStartingWithByPaging(int pageNumber, int pageSize, String words) {
//        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.DESC, "createAt");
//        String searchWords = "%" + words.trim();
//        return logRepository.findByMessageStartingWith(searchWords, pageable);
//    }

    @Transactional(readOnly = true)
    public Page<LogEntity> messageByPhrase(int pageNumber, int pageSize, String phrase) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.DESC, "createAt");
        return logRepository.findByMessage(phrase, pageable);
    }

    // 2023-05-09 14:48:00
    // 2023-05-09 14:48:00
    @Transactional(readOnly = true)
    public Page<LogEntity> messageBetween(int pageNumber, int pageSize, String startDate, String endDate) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.DESC, "createAt");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.debug("##### Days: {}", ChronoUnit.DAYS.between(startDateTime, endDateTime));
        log.debug("### startDateTime: {}", startDateTime.toString());
        log.debug("### endDateTime: {}", endDateTime.toString());

        return logRepository.findByCreateAtBetween(startDateTime, endDateTime, pageable);
    }
}