package org.zxl.springclouddemo.sleuth.ribbonclient2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonClientController2 {
    private static Logger logger = LoggerFactory.getLogger(RibbonClientController2.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ribbon-client-2")
    public String test() {
        logger.info("RibbonClient2Controller--test() is requesting....");
        return restTemplate.getForObject("http://ribbon-client1/callRabbitClient1", String.class);
    }

    @RequestMapping("/callRabbitClient2")
    public String callRabbitClient2() {
        logger.info("RibbonClient2Controller--callRabbitClient2 is requesting...");
        return "hello ,Spring Cloud Sleuth!";
    }

    @RequestMapping("/test2")
    public String test2() {
        logger.info("RibbonClient2Controller--test2 is requesting...");
        return "hello ,Spring Cloud Sleuth test2!";
    }


    @RequestMapping("/test3")
    public String test3() {
        logger.info("RibbonClient2Controller--test3 is requesting...");
        return "hello ,Spring Cloud Sleuth test3!";
    }
}
