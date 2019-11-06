package com.datahan.nacosserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim Han
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosServerApplication.class, args);

        @RestController
        class EchoController {
            @GetMapping(value = "/echo/{string}")
            public String echo(@PathVariable String string) {
                return string;
            }
        }
    }

}
