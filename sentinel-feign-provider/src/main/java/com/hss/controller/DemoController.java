package com.hss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/feign")
    public String feign(){

        return "hello sentinel feign";
    }

    @GetMapping(value = "/test")
    public String test(){

        return "hello sentinel test";
    }
}
