package com.datahan.server.sumatra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ServerSumatraApplication
 * @Description 
 * @Author Jim Han
 * @Date 2019/11/6
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ServerSumatraApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerSumatraApplication.class, args);
    }

}
