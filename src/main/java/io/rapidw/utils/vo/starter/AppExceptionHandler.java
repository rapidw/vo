/**
 * Copyright 2024 Rapidw
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
