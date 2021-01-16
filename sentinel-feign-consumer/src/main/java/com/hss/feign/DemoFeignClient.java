package com.hss.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "sentinel-feign-provider",fallback = DemoFeignClientFallback.class)
public interface DemoFeignClient {

    @GetMapping(value = "/feign")
    public String feign();
}
