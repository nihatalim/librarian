package tr.com.nihatalim.librarian.infra.checkout.rest.exception;

import org.springframework.http.HttpStatus;

import tr.com.nihatalim.librarian.infra.common.rest.exception.BaseException;

public class UserCannotBeOperatorException extends BaseException {
    private static final String MESSAGE = "User cannot be operator!";

    public UserCannotBeOperatorException() {
        super(MESSAGE, HttpStatus.BAD_REQUEST);
    }
}
