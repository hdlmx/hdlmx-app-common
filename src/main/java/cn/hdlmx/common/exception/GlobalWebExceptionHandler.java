package cn.hdlmx.common.exception;

import cn.hdlmx.common.baseEnum.BizCode;
import cn.hdlmx.common.http.ResponseResult;
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
import java.util.Optional;

/**
 * 全局异常处理
 *
 * @author 503330348
 */
@RestControllerAdvice(basePackages = {"cn.hdlmx"})

@Slf4j
public class GlobalWebExceptionHandler {
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseResult<String> handler(AccessDeniedException e) {
        log.info("http 403错误", e);
        return ResponseResult.FAILED(BizCode.HTTP_PROTOCOL_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult<String> handler(MethodArgumentNotValidException e) {
        log.info("http 400参数错误", e);
        BindingResult bindingResult = e.getBindingResult();
        Optional<ObjectError> error = bindingResult.getAllErrors().stream().findFirst();
        return ResponseResult.FAILED(BizCode.HTTP_PROTOCOL_ERROR, error.map(DefaultMessageSourceResolvable::getDefaultMessage).orElse(null));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ResponseResult<String> handler(Exception e) {
        log.error("http 500错误", e);
        return ResponseResult.FAILED(BizCode.HTTP_PROTOCOL_ERROR);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseResult<String> handler(UnauthorizedException e) {
        log.error("http 401未授权错误", e);
        return ResponseResult.FAILED(BizCode.HTTP_PROTOCOL_ERROR);
    }

}
