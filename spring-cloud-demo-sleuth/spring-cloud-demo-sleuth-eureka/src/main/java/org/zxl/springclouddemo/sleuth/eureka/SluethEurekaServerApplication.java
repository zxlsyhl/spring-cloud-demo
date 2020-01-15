package org.zxl.springclouddemo.sleuth.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SluethEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SluethEurekaServerApplication.class,args);
    }
}
