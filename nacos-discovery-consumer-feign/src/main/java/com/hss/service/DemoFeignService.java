package com.hss.service;

import com.hss.service.impl.DemoFeignServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//服务降级失效，原因未知
//@FeignClient(value = "nacos-discovery-provider",fallbackFactory = DemoFeignServiceFallbackFactory.class)
@FeignClient(value = "nacos-discovery-provider")
public interface DemoFeignService {

    @GetMapping(value = "/demo")
    public String demo(@RequestParam(value = "name",required = true) String name);
}
