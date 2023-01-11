package com.example.dms.common.ExceptionConfig;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhouy
 * @date 2022/12/31
 * good 12
 */
@RestControllerAdvice
public class GlobleExceptionController {
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e){
        if ( e instanceof NullPointerException ){

        }else {

        }
        return e.getMessage();
    }
}
