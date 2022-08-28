package com.hss.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hss.bolckHandler.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ParamController {

    @GetMapping(value = "/param123")
    @SentinelResource(value = "param123",blockHandlerClass = ExceptionUtil.class,blockHandler = "exHandlerParam")
    public String param(@RequestParam(value = "type") String type, HttpServletRequest request){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(request.getRemoteAddr());
        return "success";
    }
}
