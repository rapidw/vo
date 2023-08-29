package io.rapidw.vo.exception;

public enum DefaultAppStatus implements AppStatus {
    SUCCESS(0, "SUCCESS"),
    INVALID_REQUEST(20002, "INVALID_REQUEST"),
    NO_PERMISSION(20001, "NO_PERMISSION"),
    INTERNAL_ERROR(20003, "INTERNAL_ERROR");
    private final int code;

    private final String message;

    DefaultAppStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
