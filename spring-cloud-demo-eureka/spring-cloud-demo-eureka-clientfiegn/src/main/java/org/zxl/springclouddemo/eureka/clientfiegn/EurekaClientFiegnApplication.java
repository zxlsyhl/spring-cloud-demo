package org.zxl.springclouddemo.eureka.clientfiegn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "zxl.com.eurekaclientfiegn.service")
@EnableDiscoveryClient
public class EurekaClientFiegnApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFiegnApplication.class,args);
    }
}
