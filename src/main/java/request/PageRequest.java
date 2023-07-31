package request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param <T> 对MPJ：返回值的类型，对MP：entity的类型
 */
@ApiModel
public class PageRequest<T> {
    @ApiModelProperty("页码")
    private long pageNum = 1;
    @ApiModelProperty("每页数量")
    private long pageSize = 10;

    public Page<T> toPage() {
        return new MyPage();
    }

    private class MyPage extends Page<T> {
        @Override
        public long getSize() {
            return pageSize;
        }

        @Override
        public long getCurrent() {
            return pageNum;
        }
    }
}
