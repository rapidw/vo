/**
 * Copyright 2023 Rapidw
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

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.val;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public static <T, R> PageResponse<R> of(IPage<T> page, Function<T, R> converter) {
        val data = page.getRecords().stream().map(converter).collect(Collectors.toList());
        return new PageResponse<>(data, page.getCurrent(), page.getSize(), page.getTotal());
    }

    private PageResponse(List<T> data, long pageNum, long pageSize, long total) {
        super(data);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }
}
