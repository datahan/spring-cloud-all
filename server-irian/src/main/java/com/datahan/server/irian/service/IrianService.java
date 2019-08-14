package com.datahan.server.irian.service;

import java.net.URL;

public interface IrianService {

    void addListByListOps(String userId, URL url);

    void addListByStringRedisTemplate(String userId, URL url);
}
