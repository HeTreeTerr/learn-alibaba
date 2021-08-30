package com.hss.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class BizService {

    @Autowired
    private RestTemplate restTemplate;

    @GlobalTransactional
    @Transactional
    public void biz(String username){

        String order_url = "http://localhost:8020/order?username=" + username;
        String pay_url = "http://localhost:8030/pay?username=" + username;
        String orderResult = restTemplate.getForObject(order_url, String.class);
        String payResult = restTemplate.getForObject(pay_url, String.class);
        System.out.println("orderResult:"+orderResult+"-------------payResult="+payResult);

        if(true){
            throw new RuntimeException("我是异常！");
        }
    }
}
