package cn.hdlmx.common.exception;

import cn.hdlmx.common.http.BaseResult;
import cn.hdlmx.common.http.BaseResultBuilder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.Optional;

/**
 * 全局异常处理
 */
@RestControllerAdvice

@Slf4j
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public BaseResult<String> handler(AccessDeniedException e) {
        log.info("权限不足：{}", e);
        return BaseResultBuilder.failed("权限不足");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResult<String> handler(MethodArgumentNotValidException e) {
        log.info("实体校验异常：----------------{}", e);
        BindingResult bindingResult = e.getBindingResult();
        Optional<ObjectError> error = bindingResult.getAllErrors().stream().findFirst();
        return BaseResultBuilder.failed(error.map(DefaultMessageSourceResolvable::getDefaultMessage).orElse(null));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public BaseResult<String> handler(IllegalArgumentException e) {
        log.error("Assert异常：----------------{}", e.getMessage());
        return BaseResultBuilder.failed(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public BaseResult<String> handler(RuntimeException e) {
        log.error(Arrays.toString(e.getStackTrace()));
        return BaseResultBuilder.failed(e.getMessage());
    }
}
