package tr.com.nihatalim.librarian.domain.checkout.exception;

public class BookAlreadyCheckedOutException extends RuntimeException {
    private static final String MESSAGE = "Book already checked out exception!";

    public BookAlreadyCheckedOutException() {
        super(MESSAGE);
    }
}
