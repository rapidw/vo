package io.rapidw.vo.response;

import io.rapidw.vo.exception.AppException;
import io.rapidw.vo.exception.DefaultAppStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BaseResponse {

    public static final BaseResponse SUCCESS = new BaseResponse(DefaultAppStatus.SUCCESS);
    public static final BaseResponse INTERNAL_SERVER_ERROR = new BaseResponse(DefaultAppStatus.INTERNAL_ERROR);

    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("消息")
    private String message;


    public BaseResponse(AppException e) {
        this(e.getStatus(), e.getExtraMessage());
    }

    protected BaseResponse(DefaultAppStatus status) {
        this(status, null);
    }

    public BaseResponse(DefaultAppStatus status, String extraMessage) {
        code = status.getCode();
        if (extraMessage != null) {
            message = status.getMessage() + ": " + extraMessage;
        } else {
            message = status.getMessage();
        }
    }

    public BaseResponse() {
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
