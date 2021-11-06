package tr.com.nihatalim.librarian.domain.auth.exception;

public class UserCredentialsNotValidException extends RuntimeException {
    private static final String MESSAGE = "User credentials not valid!";

    public UserCredentialsNotValidException() {
        super(MESSAGE);
    }
}
