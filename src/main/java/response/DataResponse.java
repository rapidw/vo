package response;

import exception.AppStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DataResponse<T> extends BaseResponse {
    @ApiModelProperty("数据")
    private final T data;

    protected DataResponse(T data) {
        super(AppStatus.SUCCESS);
        this.data = data;
    }

    public static <T> DataResponse<T> of(T data) {
        return new DataResponse<>(data);
    }

    public T getData() {
        return this.data;
    }
}
