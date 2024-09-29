package ru.mtuci.antivirus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/")
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam String str) {
        return "Hello world!" + str;
    }

}