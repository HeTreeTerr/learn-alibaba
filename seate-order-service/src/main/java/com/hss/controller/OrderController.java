package com.hss.controller;

import com.hss.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    public String order(@RequestParam("username") String username){
        orderService.save(username);
        return "success";
    }
}
