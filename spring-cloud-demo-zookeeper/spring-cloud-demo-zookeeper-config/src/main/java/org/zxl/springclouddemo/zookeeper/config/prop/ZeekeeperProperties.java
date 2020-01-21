package org.zxl.springclouddemo.zookeeper.config.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "org.zxl")
@RefreshScope
@Component
public class ZeekeeperProperties {
    private String age;
    private String hign;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHign() {
        return hign;
    }

    public void setHign(String hign) {
        this.hign = hign;
    }
}
