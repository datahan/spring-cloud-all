package com.datahan.apigateway.controller;

import com.datahan.common.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 */
@RestController
public class GatewayController {

    @RequestMapping("/failure")
    public ResponseResult fallBack() {
        return ResponseResult.error("访问的服务不可用，Hystrix起作用了！");
    }
}
