package com.hdu.springcloud.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;


import reactor.core.publisher.Mono;

@Component
public class IPCheckFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        // 此处写死了，演示用，实际中需要采取配置的方式 Authorization:"Basic SmF2YTptaXhpYW9kb25n",Host:"localhost:9527",
        String auth = "Java:mixiaodong";// 认证信息
		byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodeAuth);
		ServerWebExchange build =null;
        if (headers.get("Authorization") == null) {
        	System.out.println(" 前置 : " +exchange.getRequest().getBody() + "\t"+ exchange.getRequest().getURI().toString());
            String token = exchange.getRequest().getQueryParams().getFirst("token");
            System.out.println("token------->"+token);
          //是不能直接向 headers中放文件的
            // exchange.getRequest().getHeaders().add("inner-token", token2);
            //向headers中放文件，记得build
            ServerHttpRequest host = exchange.getRequest().mutate().header("Authorization", authHeader).build();
            //将现在的request 变成 change对象
            build = exchange.mutate().request(host).build();
		}
        
        return chain.filter(build).then(Mono.fromRunnable(()->{
        	System.out.println(" 后置 : " +exchange.getResponse().getStatusCode() + "\t"+ exchange.getRequest().getURI().toString());
        }));
    }



}
