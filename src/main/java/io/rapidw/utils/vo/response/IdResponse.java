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

import lombok.Data;
import lombok.experimental.Accessors;

public class IdResponse extends DataResponse<IdResponse.Id>{

    protected IdResponse(Integer id) {
        super(new Id().setId(id));
    }

    public static IdResponse of(Integer id) {
        return new IdResponse(id);
    }

    @Data
    @Accessors(chain = true)
    public static class Id {
        private Integer id;
    }
}
