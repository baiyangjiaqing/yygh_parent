package com.atwjq.yygh.common.exception;

import com.atwjq.yygh.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther:Administrator
 * @Description:
 * @CreateTime:2021-07-06-15:13
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result error(Exception exception) {
        exception.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(YyghException.class)
    public Result error(YyghException exception) {
        exception.printStackTrace();
        return Result.build(exception.getCode(),exception.getMessage());
    }
}
