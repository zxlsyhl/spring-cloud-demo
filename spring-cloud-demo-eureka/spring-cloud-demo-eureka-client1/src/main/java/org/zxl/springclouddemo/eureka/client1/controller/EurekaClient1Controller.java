package org.zxl.springclouddemo.eureka.client1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zxl.springclouddemo.eureka.client1.service.HelloService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EurekaClient1Controller {
    @GetMapping("/helloAdd")
    public String helloAdd(){
        System.out.println("helloAdd:"+request.getHeader("hello"));
        System.out.println("token:"+request.getHeader("token"));
        return "i am eureka client 1";
    }


    @GetMapping("/helloFirst")
    public String helloFirst(){
        System.out.println("helloFirst"+request.getHeader("hello"));
        System.out.println("token:"+request.getHeader("token"));
        return "i am eureka client 2";
    }

    @Autowired
    private HelloService helloService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/getFiegnClientHello")
    public String getFiegnClientHello(){
        System.out.println("getFiegnClientHello:"+request.getHeader("hello"));
        return helloService.helloFiegn();
    }
}
