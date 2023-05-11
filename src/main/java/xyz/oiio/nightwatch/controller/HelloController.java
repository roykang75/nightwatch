package xyz.oiio.nightwatch.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.oiio.nightwatch.entity.LogEntity;
import xyz.oiio.nightwatch.service.LogService;

import java.util.List;

@Tag(name = "Hello", description = "Hello API 입니다.")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "hello/v1")
public class HelloController {

    private final LogService logService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello";
    }

}
