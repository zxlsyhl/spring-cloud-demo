package org.zxl.springclouddemo.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public String hello(){
        return "hello consumer";
    }

    @GetMapping("/hello2")
    public String hello2(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-producer");
        return new RestTemplate().getForObject(serviceInstance.getUri()+"/hello",String.class);
    }
}
