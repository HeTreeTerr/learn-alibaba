package com.hss.controller;

import com.hss.feign.DemoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoFeignClient demoFeignClient;

    @GetMapping(value = "/hello")
    public String hello(){

        return demoFeignClient.feign();
    }
}
