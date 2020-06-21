package library.common.exception;


import org.springframework.http.HttpStatus;

public class NotFoundException extends WebServerException {

    public NotFoundException(String errorMsg) {
        super(HttpStatus.NOT_FOUND, errorMsg);
    }

}
