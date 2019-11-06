package com.datahan.server.sulawesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ServerSulawesiApplication
 * @Description 
 * @Author Jim Han
 * @Date 2019/11/6
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ServerSulawesiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerSulawesiApplication.class, args);
    }

    @RestController
    class EchoController {
        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string) {
            return string;
        }
    }
}
