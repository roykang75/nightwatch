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

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LogService {
    private final LogRepository logRepository;

    @Transactional(readOnly = true)
    public List<LogEntity> findAll(){
        return logRepository.findAll(PageRequest.of(0, 100)).toList();
    }

    @Transactional(readOnly = true)
    public Page<LogEntity> findAllByOrderByCreateAtDesc(){
            Pageable pageable = Pageable.ofSize(1000).withPage(1);
          return logRepository.findAllByOrderByCreateAtDesc(pageable);
    }

    @Transactional(readOnly = true)
    public Page<LogEntity> CreateAtDescByPaging(int perPage, int perSize) {
        Pageable pageable = PageRequest.of(perPage - 1, perSize, Sort.Direction.DESC, "createAt");
//        Pageable pageable = Pageable.ofSize(perSize).withPage(perPage);
        return logRepository.findAllByOrderByCreateAtDesc(pageable);
    }

    @Transactional(readOnly = true)
    public Page<LogEntity> MessageLikeByPaging(int perPage, int perSize, String words) {
        Pageable pageable = Pageable.ofSize(perSize).withPage(perPage);
        String searchWords = "%" + words.trim() + "%";
        return logRepository.findByMessageLike(searchWords, pageable);
    }

    @Transactional(readOnly = true)
    public Page<LogEntity> MessageContainsByPaging(int perPage, int perSize, String words) {
        Pageable pageable = Pageable.ofSize(perSize).withPage(perPage);
        String searchWords = words.trim();
        return logRepository.findByMessageContains(searchWords, pageable);
    }

    @Transactional(readOnly = true)
    public Page<LogEntity> MessageStartingWithByPaging(int perPage, int perSize, String words) {
        Pageable pageable = Pageable.ofSize(perSize).withPage(perPage);
        String searchWords = "%" + words.trim();
        return logRepository.findByMessageStartingWith(searchWords, pageable);
    }
}
