package com.datahan.apigateway.controller;

import com.datahan.common.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author Jim
 */
@RestController
public class GatewayController {

    @RequestMapping("/failure")
    public ResponseResult fallBack() {
        return ResponseResult.error("访问的服务不可用，Hystrix起作用了！");
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

    @RequestMapping("/shortreq")
    public ResponseResult shortreq() {
        return ResponseResult.success("shortreq操作成功");
    }

    @RequestMapping("/longreq")
    public ResponseResult longreq() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseResult.success("longreq操作成功");
    }
}
