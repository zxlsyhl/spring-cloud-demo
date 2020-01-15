package org.zxl.springclouddemo.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class,args);
    }

    @Value("${demo}")
    private String demo;

    @Value("${democonfigclient.message}")
    private String  message;

    @GetMapping("/getdemo")
    public String getdemo(){
        return demo;
    }


    @GetMapping("/getMessage")
    public String message(){
        return message;
    }

//    兆殷特

}
