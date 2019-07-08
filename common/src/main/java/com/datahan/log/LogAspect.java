package com.datahan.log;

import com.datahan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Around("within(com.datahan..*) && @annotation(logCut)")
    public void around(ProceedingJoinPoint joinPoint, LoggerCut logCut) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("{} 方法开始, 入参: {} ", logCut.value(), JsonUtil.toJsonString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        long costTime = System.currentTimeMillis() - startTime;
        log.info("{} 方法结束, 出参: {} , 耗时：{}", logCut.value(), JsonUtil.toJsonString(result), costTime);
    }

    @AfterThrowing(pointcut = "within(com.datahan..*) && @annotation(logCut)", throwing = "ex")
    public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerCut logCut, Exception ex) {
        if (log.isInfoEnabled()) {
            log.error("{} 方法异常", logCut.value(), ex);
        }
    }

}
