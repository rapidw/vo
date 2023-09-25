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
package io.rapidw.utils.vo.exception;

import lombok.Getter;

import java.util.function.Supplier;

public class AppException extends RuntimeException {

    @Getter
    private final AppStatus status;
    private String extraMessage;

    public AppException(AppStatus status) {
        this.status = status;
    }

    public AppException(AppStatus status, String extraMessage) {
        this.status = status;
        this.extraMessage = extraMessage;
    }

    public static <T> T notNull(T object, String fieldName) {
        if (object == null) {
            throw new AppException(DefaultAppStatus.INVALID_REQUEST, fieldName + "不能为空");
        }
        return object;
    }

    public static Supplier<AppException> of(AppStatus status, String extraMessage) {
        return () -> new AppException(status, extraMessage);
    }

    @Override
    public String getMessage() {
        return status.getMessage() + ": " + extraMessage;
    }
}
