package com.datahan.server.irian.controller;

import com.datahan.common.ResponseResult;
import com.datahan.server.irian.service.IrianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
public class IrianController {

    @Autowired
    private IrianService irianService;

    @PostMapping("/addListByListOps")
    public ResponseResult addListByListOps(String userId, URL url) {
        irianService.addListByListOps(userId, url);
        return ResponseResult.success();
    }

    @PostMapping("/addListByStringRedisTemplate")
    public ResponseResult addListByStringRedisTemplate(String userId, URL url) {
        irianService.addListByStringRedisTemplate(userId, url);
        return ResponseResult.success();
    }
}
