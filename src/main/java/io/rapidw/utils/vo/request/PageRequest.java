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
package io.rapidw.utils.vo.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @param <T> 对MPJ：返回值的类型，对MP：entity的类型
 */
@Schema()
@Data
public class PageRequest<T> {
    @Schema(description = "页码")
    private long pageNum = 1;
    @Schema(description = "每页数量")
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
