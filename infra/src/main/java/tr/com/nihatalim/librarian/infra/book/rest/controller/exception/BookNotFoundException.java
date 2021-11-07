package tr.com.nihatalim.librarian.infra.book.rest.controller.exception;

import org.springframework.http.HttpStatus;

import tr.com.nihatalim.librarian.infra.common.rest.exception.BaseException;

public class BookNotFoundException extends BaseException {
    private static final String MESSAGE = "Book not found!";

    public BookNotFoundException() {
        super(MESSAGE, HttpStatus.NOT_FOUND);
    }
}
