package org.zxl.springclouddemo.eureka.client1.configurers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zxl.springclouddemo.eureka.client1.interceptors.RibbonInterceptor;

/**
 * 拦截器配置类
 */
@Configuration
public class WebMvcSessionConfigurer implements WebMvcConfigurer {
    // @Autowired
    // RibbonInterceptor ribbonInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用于排除拦截
        // old: new RedisSessionInterceptor()
        // registry.addInterceptor(ribbonInterceptor).addPathPatterns("/**");
        registry.addInterceptor(new RibbonInterceptor()).addPathPatterns("/**");
    }

}