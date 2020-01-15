package org.zxl.springclouddemo.eureka.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.zxl.springclouddemo.eureka.client1.restTemplate.MyRestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class EurekaClientApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication1.class,args);
    }

    @Bean
    @LoadBalanced
    public MyRestTemplate myRestTemplate(){
        return new MyRestTemplate();
    }
}
