package tr.com.nihatalim.librarian.infra.book.converter;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.book.model.Book;
import tr.com.nihatalim.librarian.domain.common.converter.BaseConverter;
import tr.com.nihatalim.librarian.infra.book.persistence.entity.BookEntity;

@Component
public class BookConverter implements BaseConverter<BookEntity, Book> {
    @Override
    public Book convert(BookEntity model) {
        return Book.builder()
            .id(model.getId())
            .createdAt(model.getCreatedAt())
            .updatedAt(model.getUpdatedAt())
            .title(model.getTitle())
            .ISBN(model.getISBN())
            .coverPrice(model.getCoverPrice())
            .image(model.getImage())
            .status(model.getStatus())
            .publishYear(model.getPublishYear())
            .build();
    }
}
