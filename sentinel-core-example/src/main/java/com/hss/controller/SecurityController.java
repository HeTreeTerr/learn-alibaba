package com.hss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping(value = "/white")
    public String white(){
        return "hello white";
    }

    @GetMapping(value = "/black")
    public String black(){
        return "hello black";
    }
}
