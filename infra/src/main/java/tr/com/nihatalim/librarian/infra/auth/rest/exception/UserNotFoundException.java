package tr.com.nihatalim.librarian.infra.auth.rest.exception;

import org.springframework.http.HttpStatus;

import tr.com.nihatalim.librarian.infra.common.rest.exception.BaseException;

public class UserNotFoundException extends BaseException {
    private static final String MESSAGE = "User not found!";

    public UserNotFoundException() {
        super(MESSAGE, HttpStatus.NOT_FOUND);
    }
}
