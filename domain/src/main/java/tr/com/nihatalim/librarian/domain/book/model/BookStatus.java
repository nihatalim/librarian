package tr.com.nihatalim.librarian.domain.book.model;

public enum BookStatus {
    CHECK_IN("check-in"),
    CHECK_OUT("check-out");

    private final String value;

    BookStatus(String value) {
        this.value = value;
    }
}
