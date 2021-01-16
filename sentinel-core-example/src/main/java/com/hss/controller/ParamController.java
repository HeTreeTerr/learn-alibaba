package com.hss.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.hss.bolckHandler.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ParamController {

    @GetMapping(value = "/param")
    @SentinelResource(value = "parm",blockHandlerClass = ExceptionUtil.class,blockHandler = "exHandlerParam")
    public String param(String type,HttpServletRequest request){

        System.out.println(request.getRemoteAddr());
        return "success";
    }
}
