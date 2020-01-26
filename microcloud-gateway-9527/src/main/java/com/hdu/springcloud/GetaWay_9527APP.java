package com.hdu.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GetaWay_9527APP {

	private static final Logger logger = LoggerFactory.getLogger(GetaWay_9527APP.class);

  /*  @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/baidu")
                        .uri("http://baidu.com:80/")
                )
               .route("websocket_route", r -> r.path("/apitopic1/**")
                .uri("ws://127.0.0.1:6605"))
                .route("MICROCLOUD-DEPT",r -> r.path("/mmm/**")
                        .filters(f -> f.addRequestHeader("Java", "mixiaodong"))

                        .uri("lb://MICROCLOUD-DEPT/")
                )
                .build();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(GetaWay_9527APP.class, args);
        logger.info(" Start APIGatewayApplication Done");
    }


}
