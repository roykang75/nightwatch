package xyz.oiio.nightwatch.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.oiio.nightwatch.service.LogService;

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
