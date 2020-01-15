package org.zxl.springclouddemo.eureka.client1.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zxl.springclouddemo.eureka.client1.restTemplate.MyRestTemplate;

@Service
public class HelloService {
    @Autowired
    private MyRestTemplate myRestTemplate;

    @HystrixCommand(fallbackMethod="helloFiegn_back")
    public String helloFiegn(){
        return myRestTemplate.getForObject("http://feign-client/helloFiegn",String.class);
    }

    public String helloFiegn_back(){
        return "服务繁忙，休息一会儿";
    }
}
