package com.datahan.server.amager.controller;

import com.datahan.log.LogAspect;
import com.datahan.server.amager.domain.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Jimmy
 */
@RestController
@Slf4j
public class AmagerController {

    @Autowired
    private HttpServletRequest request;

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    @LogAspect("执行greeting方法")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String hobby = request.getHeader("Hobby");
        log.info("hobby is a " + hobby);
        return new Greeting(counter.incrementAndGet(),
                String.format(TEMPLATE, name));
    }
}
