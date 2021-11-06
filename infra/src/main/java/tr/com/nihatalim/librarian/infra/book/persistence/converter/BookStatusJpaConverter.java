package tr.com.nihatalim.librarian.infra.book.persistence.converter;

import tr.com.nihatalim.librarian.domain.book.model.BookStatus;

import javax.persistence.AttributeConverter;

public class BookStatusJpaConverter implements AttributeConverter<BookStatus, String> {
    @Override
    public String convertToDatabaseColumn(BookStatus bookStatus) {
        return bookStatus.getValue();
    }

    @Override
    public BookStatus convertToEntityAttribute(String s) {
        return BookStatus.fromValue(s);
    }
}
