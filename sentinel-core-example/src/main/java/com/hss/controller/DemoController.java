package com.hss.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hss.bolckHandler.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/demo")
    @SentinelResource(value = "demo",blockHandler = "exHandler",blockHandlerClass = {ExceptionUtil.class})
    public String demo(){
        try {
            //模拟逻辑处理耗时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello sentinel";
    }

    @GetMapping(value = "/resource")
    //自定义基于资源的控流反馈
    //@SentinelResource(value = "resource",blockHandler = "exHandler")
    @SentinelResource(value = "resource",blockHandler = "exHandler",blockHandlerClass = {ExceptionUtil.class})
    public String resource(){
        try {
            //模拟逻辑处理耗时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello resource";
    }

    @GetMapping(value = "/fallback")
    //自定义基于资源的熔断反馈
    @SentinelResource(value = "fallback",fallback = "fallbackHandler",fallbackClass = {ExceptionUtil.class})
    public String fallback(@RequestParam(value = "param",required = false) String param){
        if(true){
            throw new RuntimeException("运行时异常！");
        }
        return "hello fallback";
    }

    public String exHandler(BlockException ex){
        return "error resource";
    }
}
