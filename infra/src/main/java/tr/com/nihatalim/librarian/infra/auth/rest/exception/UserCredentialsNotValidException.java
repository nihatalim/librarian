package tr.com.nihatalim.librarian.infra.auth.rest.exception;

import org.springframework.http.HttpStatus;

import tr.com.nihatalim.librarian.infra.common.rest.exception.BaseException;

public class UserCredentialsNotValidException extends BaseException {
    private static final String MESSAGE = "User credentials not valid!";

    public UserCredentialsNotValidException() {
        super(MESSAGE, HttpStatus.BAD_REQUEST);
    }
}
