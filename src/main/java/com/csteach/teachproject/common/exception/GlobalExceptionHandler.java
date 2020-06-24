package com.csteach.teachproject.common.exception;

import com.csteach.teachproject.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e){
        log.error("运行时异常:--------{}",e.getMessage());
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handler(MethodArgumentNotValidException e){
        log.error("实体验证异常:--------{}",e.getMessage());
        BindingResult bindingResult= e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        String msg = objectError.getDefaultMessage();

        return Result.fail(msg);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result handler(IllegalArgumentException e){
        log.error("assert异常:--------{}",e.getMessage());

        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(value = CommonException.class)
    public Result handler(CommonException e){
        log.error("通用异常:--------{}",e.getMessage());

        return Result.fail(e.getMessage());
    }

}
