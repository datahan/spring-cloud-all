package com.datahan.exception;

import com.datahan.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理
 * @author Jim
 */
@Slf4j
@RestControllerAdvice
public class BizExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BizException.class)
    public ResponseResult handleBizException(BizException e){
        log.error(e.getMsg(), e);
        return ResponseResult.bizError(e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e){
        log.error(e.getMessage(), e);
        return ResponseResult.sysError(e.getMessage());
    }
}