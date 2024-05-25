package competition.transport.errors;

public class NotFoundRequestException extends RuntimeException {
    public NotFoundRequestException() {
    }

    public NotFoundRequestException(String message) {
        super(message);
    }

    public NotFoundRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundRequestException(Throwable cause) {
        super(cause);
    }

    public NotFoundRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
