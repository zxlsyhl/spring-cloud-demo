package org.zxl.springclouddemo.zookeeper.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public String hello(){
        return "hello zookeeper";
    }

    @GetMapping("/hello2")
    public String hello2(){
//        discoveryClient.getInstances("zookeeper-producer")
        ServiceInstance serviceInstance = loadBalancerClient.choose("zookeeper-producer");
        System.out.println("服务地址："+serviceInstance.getUri());
        System.out.println("服务名称："+serviceInstance.getServiceId());
        String result = new RestTemplate().getForObject(serviceInstance.getUri()+"/hello", String.class);
        System.out.println(result);
        return result;
    }

}
