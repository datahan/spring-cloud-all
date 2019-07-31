package com.datahan.server.kalimantan.controller;

import com.datahan.server.kalimantan.domain.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class KalimantanController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/amager/greeting")
    public Greeting greeting() {
        return this.restTemplate.getForObject("http://localhost:9001/amager/greeting", Greeting.class);
    }

}
