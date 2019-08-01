package com.datahan.server.kalimantan.controller;

import com.datahan.server.kalimantan.domain.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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
        // 注意：前面的amager是虚拟主机地址，等同于ip:port，后者amager是项目名
        return this.restTemplate.getForObject("http://amager/amager/greeting", Greeting.class);
    }

    @GetMapping("/log-instantce")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("amager");
        log.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

}
