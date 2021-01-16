package com.hss.feign;

import org.springframework.stereotype.Component;

@Component
public class DemoFeignClientFallback implements DemoFeignClient {

    @Override
    public String feign() {
        return "sentinel feign error";
    }
}
