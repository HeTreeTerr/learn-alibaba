package com.hss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoProController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/demo")
    public String demo(@RequestParam(value = "name",required = true) String name){
        logger.info("-------------provider-----------");
        return "hello "+name;
    }
}
