package io.rapidw.vo.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.List;

@Getter
@ApiModel
public class PageResponse<T> extends DataResponse<List<T>> {

    @ApiModelProperty("当前页码")
    private final long pageNum;
    @ApiModelProperty("每页大小")
    private final long pageSize;
    @ApiModelProperty("总数")
    private final long total;

    protected PageResponse(IPage<T> page) {
        super(page.getRecords());
        this.pageNum = page.getCurrent();
        this.pageSize = page.getSize();
        this.total = page.getTotal();
    }


    public static <T> PageResponse<T> of(IPage<T> page) {
        return new PageResponse<>(page);
    }
    public static <T> PageResponse<T> of(List<T> data, long pageNum, long pageSize, long total) {
        return new PageResponse<>(data, pageNum, pageSize, total);
    }

    private PageResponse(List<T> data, long pageNum, long pageSize, long total) {
        super(data);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }
}
