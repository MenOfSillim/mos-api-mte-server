package club.menofsillim.apimte.contents.mainpage.domain.mosmember;

import club.menofsillim.apimte.global.common.exception.ResourceDuplicateException;
import org.springframework.http.HttpStatus;

public class MosMemberDuplicateException extends ResourceDuplicateException {

    public MosMemberDuplicateException() {
    }

    public MosMemberDuplicateException(String message) {
        super(message);
    }

    public MosMemberDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public MosMemberDuplicateException(Throwable cause) {
        super(cause);
    }

    public MosMemberDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return super.getHttpStatus();
    }

    @Override
    public boolean isNecessaryToLog() {
        return super.isNecessaryToLog();
    }
}
