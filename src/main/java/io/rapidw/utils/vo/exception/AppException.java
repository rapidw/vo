package io.rapidw.utils.vo.exception;


public class AppException extends RuntimeException {

    private final DefaultAppStatus status;
    private String extraMessage;

    public AppException(DefaultAppStatus status) {
        this.status = status;
    }

    public AppException(DefaultAppStatus status, String extraMessage) {
        this.status = status;
        this.extraMessage = extraMessage;
    }

    public static <T> T notNull(T object, String fieldName) {
        if (object == null) {
            throw new AppException(DefaultAppStatus.INVALID_REQUEST, fieldName + "不能为空");
        }
        return object;
    }

    public DefaultAppStatus getStatus() {
        return this.status;
    }

    public String getExtraMessage() {
        return this.extraMessage;
    }
}
