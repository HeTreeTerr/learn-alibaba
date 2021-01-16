package com.hss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.alibaba.nacos.ribbon.NacosServer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

@RestController
public class DemoConController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WebClient.Builder webClientBuilder;

    //nacos-discovery-provider
    @GetMapping(value = "/test")
    public Mono<String> test(@RequestParam(value = "name",required = true) String name){
        return webClientBuilder.build().get()
                .uri("http://nacos-discovery-provider/demo?name=" + name)
                .retrieve()
                .bodyToMono(String.class);
    }

    //nacos-discovery-gateway-server
    @GetMapping(value = "/testGateway")
    public Mono<String> testGateway(@RequestParam(value = "name",required = true) String name){
        return webClientBuilder.build().get()
                .uri("http://nacos-discovery-gateway-server/provider/demo?name=" + name)
                .retrieve()
                .bodyToMono(String.class);
    }

}
