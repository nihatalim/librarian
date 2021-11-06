package tr.com.nihatalim.librarian.domain.book.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum BookStatus {
    CHECK_IN("check-in"),
    CHECK_OUT("check-out");

    private final String value;

    BookStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static BookStatus fromValue(String value) {
        return Arrays.stream(BookStatus.values())
                .filter(item -> item.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
