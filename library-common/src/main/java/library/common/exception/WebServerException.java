package library.common.exception;

import org.springframework.http.HttpStatus;

public class WebServerException extends RuntimeException {

    private final HttpStatus code;

    public WebServerException(HttpStatus code, String message) {
        super(message);
        this.code = code;
    }

    public WebServerException(HttpStatus code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }
}
