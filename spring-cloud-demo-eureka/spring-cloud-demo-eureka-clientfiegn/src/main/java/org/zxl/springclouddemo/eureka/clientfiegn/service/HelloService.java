package org.zxl.springclouddemo.eureka.clientfiegn.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.zxl.springclouddemo.eureka.clientfiegn.hystrix.HelloServiceHystrix;
import org.zxl.springclouddemo.eureka.clientfiegn.interceptors.FeignConfiguration;

/**
 * FeignConfiguration 做header传递
 */
@FeignClient(name = "ribbon-client1",fallback = HelloServiceHystrix.class, configuration = FeignConfiguration.class) //是helloserver中的服务注册名称，不区分大小写
public interface HelloService {
    @GetMapping("/helloAdd")
    String helloAdd();
}