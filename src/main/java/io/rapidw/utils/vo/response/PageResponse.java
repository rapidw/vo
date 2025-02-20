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

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;

@Getter
@Schema
public class PageResponse<T> extends DataResponse<List<T>> {

    /**
     * current page number
     */
    @Schema(description = "当前页码")
    private final long pageNum;
    /**
     * size of page
     */
    @Schema(description = "每页大小")
    private final long pageSize;
    /**
     * total count of data
     */
    @Schema(description = "总数")
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
        return of(page.convert(converter));
    }

    private PageResponse(List<T> data, long pageNum, long pageSize, long total) {
        super(data);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }
}
