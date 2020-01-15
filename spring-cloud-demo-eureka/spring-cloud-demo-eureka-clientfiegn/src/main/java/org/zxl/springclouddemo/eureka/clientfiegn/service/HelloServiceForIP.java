package org.zxl.springclouddemo.eureka.clientfiegn.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.zxl.springclouddemo.eureka.clientfiegn.hystrix.HelloServiceHystrixByIp;

@FeignClient(name = "ribbon-client2",url = "http://localhost:3333",fallback = HelloServiceHystrixByIp.class) //name是服务注册名称，不区分大小写，url指定时name不生效。fallback指定熔断类。
public interface HelloServiceForIP {
    @GetMapping("/helloAdd")
    String helloAdd();
}