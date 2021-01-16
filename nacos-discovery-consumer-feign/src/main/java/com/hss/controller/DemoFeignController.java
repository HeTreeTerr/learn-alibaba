package com.hss.controller;

import com.hss.service.DemoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoFeignController {

    @Autowired
    private DemoFeignService demoFeignService;

    @GetMapping(value = "/test")
    public String test(@RequestParam(value = "name",required = true) String name){

        return this.demoFeignService.demo(name);
    }
}
