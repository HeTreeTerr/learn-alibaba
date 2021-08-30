package com.hss.controller;

import com.hss.service.BizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BizController {

    @Autowired
    private BizService bizService;

    @RequestMapping(value = "/biz")
    public String biz(@RequestParam("username") String username){
        bizService.biz(username);
        return "success";
    }
}
