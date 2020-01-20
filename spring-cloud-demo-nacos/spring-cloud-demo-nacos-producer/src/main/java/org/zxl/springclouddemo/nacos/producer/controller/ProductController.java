package org.zxl.springclouddemo.nacos.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/hello")
    public String hello(){
        return "i am producer service";
    }
}
