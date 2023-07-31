package exception;


public class AppException extends RuntimeException {

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
            throw new AppException(AppStatus.INVALID_REQUEST, fieldName + "不能为空");
        }
        return object;
    }

    public AppStatus getStatus() {
        return this.status;
    }

    public String getExtraMessage() {
        return this.extraMessage;
    }
}
