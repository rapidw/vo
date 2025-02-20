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
package io.rapidw.utils.vo.exception;

import lombok.Getter;

@Getter
public enum CommonAppStatus implements AppStatus {
    SUCCESS(0, "SUCCESS"),
    INVALID_REQUEST(400, "INVALID_REQUEST"),
    AUTHENTICATION_REQUIRED(401, "AUTHENTICATION_REQUIRED"),
    ACCESS_DENIED(403, "ACCESS_DENIED"),
    INTERNAL_ERROR(500, "INTERNAL_ERROR");
    private final int code;

    private final String message;

    CommonAppStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
