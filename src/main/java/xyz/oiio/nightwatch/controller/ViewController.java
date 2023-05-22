package xyz.oiio.nightwatch.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.oiio.nightwatch.entity.LogEntity;
import xyz.oiio.nightwatch.service.LogService;

import java.util.List;

@Tag(name = "Search", description = "Search API 입니다.")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/search")
public class ViewController {

    private final LogService logService;

    @RequestMapping(method = RequestMethod.GET, value = "/findall")
    public ResponseEntity<Object> findAll() {
        List<LogEntity> list = logService.findAll();
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }
//    @RequestMapping(method = RequestMethod.GET, value = "/findallbycreateatdesc")
//    public ResponseEntity<Object> findAllByOrderByCreateAtDesc() {
//        Page<LogEntity> list = logService.findAllByOrderByCreateAtDesc();
//        return new ResponseEntity<Object>(list, HttpStatus.OK);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/createatdescbypaging")
//    public ResponseEntity<Object> CreateAtDescByPaging(int perPage, int perSize) {
//        Page<LogEntity> list = logService.CreateAtDescByPaging(perPage, perSize);
//        return new ResponseEntity<Object>(list, HttpStatus.OK);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/messagelike")
//    public ResponseEntity<Object> MessageLike(int perPage, int perSize, String words) {
//        Page<LogEntity> list = logService.MessageLikeByPaging(perPage, perSize, words);
//        return new ResponseEntity<Object>(list, HttpStatus.OK);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/messagecontains")
//    public ResponseEntity<Object> MessageContains(int perPage, int perSize, String words) {
//        Page<LogEntity> list = logService.MessageContainsByPaging(perPage, perSize, words);
//        return new ResponseEntity<Object>(list, HttpStatus.OK);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/messagestartwith")
//    public ResponseEntity<Object> MessageStartWith(int perPage, int perSize, String words) {
//        Page<LogEntity> list = logService.MessageStartingWithByPaging(perPage, perSize, words);
//        return new ResponseEntity<Object>(list, HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/messagebyphrase")
    public ResponseEntity<Object> MessageByPhrase(int pageNumber, int pageSize, String phrase) {
        Page<LogEntity> list = logService.MessageByPhrase(pageNumber, pageSize, phrase);
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/messagebetween")
    public ResponseEntity<Object> MessageBetween(int pageNumber, int pageSize, String startDateTime, String endDateTime) {
        Page<LogEntity> list = logService.MessageBetween(pageNumber, pageSize, startDateTime, endDateTime);
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }
}
