package club.menofsillim.apimte.global.common.exception;

import org.springframework.http.HttpStatus;

public abstract class MosException extends RuntimeException {

    public MosException() {
    }

    public MosException(String message) {
        super(message);
    }

    public MosException(String message, Throwable cause) {
        super(message, cause);
    }

    public MosException(Throwable cause) {
        super(cause);
    }

    public MosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public abstract HttpStatus getHttpStatus();

    public abstract boolean isNecessaryToLog();
}
