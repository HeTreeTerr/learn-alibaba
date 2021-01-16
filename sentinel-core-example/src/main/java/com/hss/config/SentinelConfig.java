package com.hss.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.hss.bolckHandler.DemoUrlBlockHandler;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SentinelConfig {

    @PostConstruct
    public void init(){
        //自定义配置基于url的控流反馈
        WebCallbackManager.setUrlBlockHandler(new DemoUrlBlockHandler());
        //黑白名单（ip）
        WebCallbackManager.setRequestOriginParser(new IpRequestOriginParser());
    }
}
