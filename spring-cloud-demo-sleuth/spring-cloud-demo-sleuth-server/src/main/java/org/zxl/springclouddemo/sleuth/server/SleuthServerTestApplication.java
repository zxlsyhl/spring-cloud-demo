package org.zxl.springclouddemo.sleuth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SleuthServerTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthServerTestApplication.class,args);
    }
}
