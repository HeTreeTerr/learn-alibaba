package com.hss.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hss.bolckHandler.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/demo")
    @SentinelResource(value = "demo",blockHandler = "exHandler",blockHandlerClass = {ExceptionUtil.class})
    public String demo(){

        return "hello sentinel";
    }

    @GetMapping(value = "/resource")
    //自定义基于资源的控流反馈
    //@SentinelResource(value = "resource",blockHandler = "exHandler")
    @SentinelResource(value = "resource",blockHandler = "exHandler",blockHandlerClass = {ExceptionUtil.class})
    public String resource(){

        return "hello resource";
    }

    public String exHandler(BlockException ex){
        return "error resource";
    }
}
