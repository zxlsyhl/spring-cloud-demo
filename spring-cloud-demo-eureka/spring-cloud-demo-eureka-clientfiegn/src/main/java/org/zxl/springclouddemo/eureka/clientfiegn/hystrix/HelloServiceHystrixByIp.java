package org.zxl.springclouddemo.eureka.clientfiegn.hystrix;

import org.springframework.stereotype.Component;
import org.zxl.springclouddemo.eureka.clientfiegn.service.HelloServiceForIP;

@Component
public class HelloServiceHystrixByIp implements HelloServiceForIP {
    @Override
    public String helloAdd() {
        return "服务中断，休息一会儿";
    }
}
