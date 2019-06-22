package com.datahan.server.amager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jimmy
 */
@SpringBootApplication
@ComponentScan("com.datahan.*")
public class ServerAmagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAmagerApplication.class, args);
    }

}
