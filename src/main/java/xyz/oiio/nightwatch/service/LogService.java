package xyz.oiio.nightwatch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.oiio.nightwatch.entity.LogEntity;
import xyz.oiio.nightwatch.model.LogInfo;
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

//    @Transactional(readOnly = true)
//    public List<LogEntity> findAll2(){
//        return logRepository.findAllByOrderByTimeStampAsc();
//    }
}
