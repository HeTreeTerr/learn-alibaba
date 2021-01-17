package com.hss.controller;

import com.hss.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @RequestMapping("/pay")
    public String pay(@RequestParam("username") String username){
        payService.save(username);
        return "success";
    }
}
