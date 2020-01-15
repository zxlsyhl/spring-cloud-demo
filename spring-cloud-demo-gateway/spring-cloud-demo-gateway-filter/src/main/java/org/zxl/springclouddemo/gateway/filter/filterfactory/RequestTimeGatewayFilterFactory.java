package org.zxl.springclouddemo.gateway.filter.filterfactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class RequestTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<RequestTimeGatewayFilterFactory.Config> {
    private static final Log log = LogFactory.getLog(RequestTimeGatewayFilterFactory.class);
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";
    private static final String KEY = "withParams";
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(KEY);
    }

    public RequestTimeGatewayFilterFactory() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                        if(startTime != null){
                            StringBuilder sb = new StringBuilder(exchange.getRequest().getURI().getRawPath())
                                    .append(": ")
                                    .append(System.currentTimeMillis() - startTime)
                                    .append("ms");
                            if(config.isWithParams()){
                                sb.append(" params:").append(exchange.getRequest().getQueryParams());
                            }
                            log.info(sb.toString());
                        }
                    })
            );
        });
    }

    public static class Config{
        private boolean withParams;
        public boolean isWithParams(){
            return withParams;
        }
        public  void setWithParams(boolean withParams){
            this.withParams = withParams;
        }
    }

    //向工厂中心注册工厂的名称，不写时默认工厂类名的前缀。
    @Override
    public String name() {
        return "RequestTime";
    }

//    @Override
//    public ServerHttpRequest.Builder mutate(ServerHttpRequest request) {
//        return null;
//    }
}
