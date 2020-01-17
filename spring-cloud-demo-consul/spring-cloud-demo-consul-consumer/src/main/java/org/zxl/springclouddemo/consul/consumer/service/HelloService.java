package org.zxl.springclouddemo.consul.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-producer")
public interface HelloService {
    @GetMapping("/hello")
    String hello();
}
