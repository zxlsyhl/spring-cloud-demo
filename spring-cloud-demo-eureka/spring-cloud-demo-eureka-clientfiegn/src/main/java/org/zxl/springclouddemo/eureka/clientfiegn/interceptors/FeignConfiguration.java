package org.zxl.springclouddemo.eureka.clientfiegn.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Configuration
public class FeignConfiguration implements RequestInterceptor {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void apply(RequestTemplate template) {
        System.out.println("FeignConfiguration apply invoke");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                template.header(name, values);

            }
            logger.info("feign interceptor header:{}",template);
        }
               /* Enumeration<String> bodyNames = request.getParameterNames();
                StringBuffer body =new StringBuffer();
                if (bodyNames != null) {
                    while (bodyNames.hasMoreElements()) {
                        String name = bodyNames.nextElement();
                        String values = request.getParameter(name);
                        body.append(name).append("=").append(values).append("&");
                    }
                }
                if(body.length()!=0) {
                    body.deleteCharAt(body.length()-1);
                    template.body(body.toString());
                    //logger.info("feign interceptor body:{}",body.toString());
                }*/
    }
}
