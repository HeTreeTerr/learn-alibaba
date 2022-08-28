package com.hss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DemoController {

    @GetMapping(value = "/feign")
    public String feign(){
        Integer ramdomNum = new Random().nextInt(10);
        if(ramdomNum%2 == 0){
            throw new RuntimeException();
        }
        return "hello sentinel feign";
    }

    @GetMapping(value = "/test")
    public String test(){

        return "hello sentinel test";
    }
}
