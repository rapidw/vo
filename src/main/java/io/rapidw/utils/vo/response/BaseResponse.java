/**
 * Copyright 2025 Rapidw
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
package io.rapidw.utils.vo.response;

import io.rapidw.utils.vo.exception.AppException;
import io.rapidw.utils.vo.exception.AppStatus;
import io.rapidw.utils.vo.exception.CommonAppStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema
public class BaseResponse {

    public static final BaseResponse SUCCESS = new BaseResponse(CommonAppStatus.SUCCESS);
    public static final BaseResponse AUTHENTICATION_REQUIRED = new BaseResponse(CommonAppStatus.AUTHENTICATION_REQUIRED);
    public static final BaseResponse ACCESS_DENIED = new BaseResponse(CommonAppStatus.ACCESS_DENIED);
    public static final BaseResponse INTERNAL_SERVER_ERROR = new BaseResponse(CommonAppStatus.INTERNAL_ERROR);

    @Schema(description = "状态码")
    private Integer code;
    @Schema(description = "消息")
    private String message;


    public BaseResponse(AppException e) {
        this.code = e.getStatus().getCode();
        this.message = e.getMessage();
    }

    public BaseResponse(AppStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseResponse(AppStatus status, String extraMessage) {
        this.code = status.getCode();
        this.message = status.getMessage() + ": " + extraMessage;
    }
}
