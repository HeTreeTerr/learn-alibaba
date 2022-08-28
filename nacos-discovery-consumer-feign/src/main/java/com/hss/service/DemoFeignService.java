package com.hss.service;

import com.hss.service.impl.DemoFeignServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "nacos-discovery-provider")
@FeignClient(value = "nacos-discovery-provider",fallbackFactory = DemoFeignServiceFallbackFactory.class)
@Component
public interface DemoFeignService {

    @GetMapping(value = "/demo")
    String demo(@RequestParam(value = "name",required = true) String name);
}
