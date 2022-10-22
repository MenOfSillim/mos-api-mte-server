package club.menofsillim.apimte.global.common.exception;

import org.springframework.http.HttpStatus;

public class ResourceDuplicateException extends MosException {
    public ResourceDuplicateException() {
    }

    public ResourceDuplicateException(String message) {
        super(message);
    }

    public ResourceDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceDuplicateException(Throwable cause) {
        super(cause);
    }

    public ResourceDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public boolean isNecessaryToLog() {
        return false;
    }
}
