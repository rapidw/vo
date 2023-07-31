package response;

import exception.AppException;
import exception.AppStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BaseResponse {

    public static final BaseResponse SUCCESS = new BaseResponse(AppStatus.SUCCESS);
    public static final BaseResponse INTERNAL_SERVER_ERROR = new BaseResponse(AppStatus.INTERNAL_ERROR);

    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("消息")
    private String message;


    public BaseResponse(AppException e) {
        this(e.getStatus(), e.getExtraMessage());
    }

    protected BaseResponse(AppStatus status) {
        this(status, null);
    }

    public BaseResponse(AppStatus status, String extraMessage) {
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
