package club.menofsillim.apimte.contents.mainpage.domain.skill;

import club.menofsillim.apimte.global.common.exception.ResourceDuplicateException;
import org.springframework.http.HttpStatus;

public class SkillInfoDuplicateException extends ResourceDuplicateException {

    public SkillInfoDuplicateException() {
    }

    public SkillInfoDuplicateException(String message) {
        super(message);
    }

    public SkillInfoDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public SkillInfoDuplicateException(Throwable cause) {
        super(cause);
    }

    public SkillInfoDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
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
