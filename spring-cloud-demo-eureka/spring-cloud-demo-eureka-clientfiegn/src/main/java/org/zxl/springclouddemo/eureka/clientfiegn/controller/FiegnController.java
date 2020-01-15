package org.zxl.springclouddemo.eureka.clientfiegn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zxl.springclouddemo.eureka.clientfiegn.service.HelloService;
import org.zxl.springclouddemo.eureka.clientfiegn.service.HelloServiceForIP;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FiegnController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/helloFiegn")
    public String helloFiegn(){
        System.out.println("helloFiegn:"+request.getHeader("hello"));
        return "hello fiegn!";
    }

    @Autowired
    private HelloService helloService;

    @GetMapping("/getEurekaClient1")
    public String getEurekaClient1(){
        System.out.println("call client begin");
        System.out.println("getEurekaClient1:"+request.getHeader("hello"));
        return helloService.helloAdd();
    }

    @Autowired
    private HelloServiceForIP helloServiceForIP;

    @GetMapping("/getEurekaClient1ForIP")
    public String getEurekaClient1ForIP(){
        System.out.println("call client by ip begin");
        return helloServiceForIP.helloAdd();
    }

}
