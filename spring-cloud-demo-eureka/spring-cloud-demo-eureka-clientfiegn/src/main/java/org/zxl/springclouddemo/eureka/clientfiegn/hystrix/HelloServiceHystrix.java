package org.zxl.springclouddemo.eureka.clientfiegn.hystrix;

import org.springframework.stereotype.Component;
import org.zxl.springclouddemo.eureka.clientfiegn.service.HelloService;

@Component
public class HelloServiceHystrix implements HelloService {
    @Override
    public String helloAdd() {
        return "服务中断，休息一会儿";
    }
}
