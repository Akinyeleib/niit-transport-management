package competition.transport.errors;

public class NotRequestException extends RuntimeException {
    public NotRequestException() {
    }

    public NotRequestException(String message) {
        super(message);
    }

    public NotRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotRequestException(Throwable cause) {
        super(cause);
    }

    public NotRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
