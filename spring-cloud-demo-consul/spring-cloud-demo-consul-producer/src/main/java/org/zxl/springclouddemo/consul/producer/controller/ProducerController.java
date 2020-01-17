package org.zxl.springclouddemo.consul.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @GetMapping("/hello")
    public String hello(){
        return "hello consul";
    }
}
