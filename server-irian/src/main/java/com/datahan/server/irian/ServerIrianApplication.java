package com.datahan.server.irian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jim
 */
@SpringBootApplication
@ComponentScan("com.datahan.*")
public class ServerIrianApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerIrianApplication.class, args);
    }

}
