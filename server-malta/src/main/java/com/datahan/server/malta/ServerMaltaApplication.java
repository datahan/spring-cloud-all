package com.datahan.server.malta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerMaltaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerMaltaApplication.class, args);
    }

}
