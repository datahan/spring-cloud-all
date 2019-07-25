package com.datahan.apigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class FilterConfigration {

    @Bean
    @Order(-1)
    public GlobalFilter a() {
        return (exchange, chain) -> {
            log.info("a pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("a post filter");
            }));
        };
    }

    @Bean
    @Order(0)
    public GlobalFilter b() {
        return (exchange, chain) -> {
            log.info("b pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("b post filter");
            }));
        };
    }

    @Bean
    @Order(1)
    public GlobalFilter c() {
        return (exchange, chain) -> {
            log.info("c pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("c post filter");
            }));
        };
    }
}
