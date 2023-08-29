package io.rapidw.vo.response;

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
