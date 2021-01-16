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

import java.net.URI;
import java.util.Map;

@RestController
public class DemoConController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 通过loadBalancerClient获取
     * @param name
     * @return
     */
    @GetMapping(value = "/testBalancer")
    public String test(@RequestParam(value = "name",required = true) String name){
        logger.info("-------------consumer-----------");
        RibbonLoadBalancerClient.RibbonServer ribbonServer = (RibbonLoadBalancerClient.RibbonServer)loadBalancerClient.choose("nacos-discovery-provider");
        NacosServer nacosServer = (NacosServer)ribbonServer.getServer();
        String instanceId = nacosServer.getInstance().getInstanceId();

        logger.info("元数据--------:" + nacosServer.getMetadata());
        String forObject = restTemplate.getForObject("http://nacos-discovery-provider/demo?name=" + name, String.class);

        return forObject;
    }

    /**
     * ribbon
     * @param name
     * @return
     */
    @GetMapping(value = "/testRibbon")
    public String testRibbon(@RequestParam(value = "name",required = true) String name){
        //ribbon的写法
        String forObject = restTemplate.getForObject("http://nacos-discovery-provider/demo?name=" + name, String.class);
        return forObject;
    }

}
