package com.datahan.server.greenland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jim
 */
@EnableEurekaClient
@SpringBootApplication
public class ServerGreenlandApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerGreenlandApplication.class, args);
    }

}
