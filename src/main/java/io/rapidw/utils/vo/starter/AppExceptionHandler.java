package io.rapidw.utils.vo.starter;

import io.rapidw.utils.vo.exception.AppException;
import io.rapidw.utils.vo.exception.CommonAppStatus;
import io.rapidw.utils.vo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler(AppException.class)
    public BaseResponse handleAppException(AppException e) {
        return new BaseResponse(e);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new BaseResponse(CommonAppStatus.INVALID_REQUEST, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception e) {
        log.error("error", e);
        return new BaseResponse(CommonAppStatus.INTERNAL_ERROR, e.getMessage());
    }
}
