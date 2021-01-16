package com.hss.service.impl;

import com.hss.service.DemoFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoFeignServiceFallbackFactory implements FallbackFactory<DemoFeignService> {

    @Override
    public DemoFeignService create(Throwable throwable) {

        return new DemoFeignService() {
            @Override
            public String demo(String name) {
                return "服务出错！";
            }
        };
    }
}
