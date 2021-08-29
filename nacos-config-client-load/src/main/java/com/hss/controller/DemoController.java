package com.hss.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope
 * 不用重启服务，动态刷新参数
 */
@RefreshScope
@RestController
public class DemoController {

    @Value("${name:空name}")
    public String name;

    @Value("${common:空common}")
    public String common;

    @GetMapping(value = "/testConfig")
    public String testConfig(){

        return "hello " + name;
    }

    @GetMapping(value = "/readCommon")
    public String readCommon(){
        return common;
    }
}
