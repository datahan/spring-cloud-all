package com.datahan.log;

import com.datahan.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Jim
 */
@Slf4j
@Aspect
@Component
public class LogAspectRecord {

  @Around("within(com.datahan..*) && @annotation(com.datahan.log.LogAspect)")
  public Object addLogger(ProceedingJoinPoint joinPoint) throws Throwable {

    String methodName = joinPoint.getSignature().getName();
    Class<?> classTarget = joinPoint.getTarget().getClass();
    Class<?>[] par = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
    Method objMethod = classTarget.getMethod(methodName, par);
    LogAspect logAspect = objMethod.getAnnotation(LogAspect.class);

    printLog("入参", logAspect, joinPoint.getArgs());
    Object result = joinPoint.proceed();
    printLog("出参", logAspect, result);
    return result;
  }

  private void printLog(String argDesc, LogAspect logAspect, Object args) {
    String level = logAspect.level().toUpperCase();
    String value = logAspect.value();
    if (StringUtils.isNotEmpty(value)) {
      argDesc = value +"," + argDesc;
    }

    switch (level) {
      case "TRACE":
        if (log.isTraceEnabled()) {
          log.trace(argDesc + JSONUtil.toJsonString(args));
        }
        break;
      case "DEBUG":
        if (log.isDebugEnabled()) {
          log.debug(argDesc + JSONUtil.toJsonString(args));
        }
        break;
      case "INFO":
        if (log.isInfoEnabled()) {
          log.info(argDesc + JSONUtil.toJsonString(args));
        }
        break;
      case "WARN":
        if (log.isWarnEnabled()) {
          log.warn(argDesc + JSONUtil.toJsonString(args));
        }
        break;
      case "ERROR":
        if (log.isErrorEnabled()) {
          log.error(argDesc + JSONUtil.toJsonString(args));
        }
        break;

      default:
        log.info("日志级别不存在：{}", level);
    }

  }


}
