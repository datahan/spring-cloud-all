package com.datahan.server.amager.controller;

import com.datahan.common.ContextHolder;
import com.datahan.log.LoggerCut;
import com.datahan.server.amager.domain.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Jim
 */
@RestController
@Slf4j
public class AmagerController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    @LoggerCut("执行greeting方法")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        HttpServletRequest request = ContextHolder.getRequest();
        String hobby = request.getHeader("Hobby");
        String shape = request.getHeader("Shape");
        log.info("Hobby is a " + hobby);
        log.info("Shape is a " + shape);
        return new Greeting(counter.incrementAndGet(),
                String.format(TEMPLATE, name));
    }
}
