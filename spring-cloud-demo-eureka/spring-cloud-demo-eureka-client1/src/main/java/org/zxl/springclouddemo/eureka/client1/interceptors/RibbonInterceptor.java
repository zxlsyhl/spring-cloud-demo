package org.zxl.springclouddemo.eureka.client1.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zxl.springclouddemo.eureka.client1.restTemplate.MyRestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

// @Component("ribbonInterceptor1")
public class RibbonInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(RibbonInterceptor.class);

    private MyRestTemplate myRestTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("RibbonInterceptor preHandle invoke");
        String lpfId = request.getHeader("lpf");
        if (myRestTemplate == null) {  //解决service为null无法注入问题
            BeanFactory factory =
                    WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            myRestTemplate = (MyRestTemplate) factory.getBean("myRestTemplate");
        }

        Enumeration<String> headersName = request.getHeaderNames();
        if(headersName.hasMoreElements()){
            String headerName = headersName.nextElement();
            myRestTemplate.header(headerName, request.getHeader(headerName));
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub;
    }
}