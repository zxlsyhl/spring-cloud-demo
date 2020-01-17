package org.zxl.springclouddemo.consul.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.zxl.springclouddemo.consul.consumer.service.HelloService;

import javax.annotation.Resource;

@RestController
public class CallHelloController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/call")
    public String call(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-producer");
        System.out.println("服务地址："+serviceInstance.getUri());
        System.out.println("服务名称："+serviceInstance.getServiceId());
        String result = new RestTemplate().getForObject(serviceInstance.getUri()+"/hello", String.class);
        System.out.println(result);
        return result;
    }

    /**
     * 通过feign调用
     */
//    @Autowired
    @Resource
    private HelloService helloService;

    @GetMapping("/call2")
    public String call2(){
        return helloService.hello();
    }

}
