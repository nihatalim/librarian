package tr.com.nihatalim.librarian.domain.book.converter;

import tr.com.nihatalim.librarian.domain.book.dto.response.BookDto;
import tr.com.nihatalim.librarian.domain.book.model.Book;
import tr.com.nihatalim.librarian.domain.common.converter.BaseConverter;

public class BookDtoConverter implements BaseConverter<Book, BookDto> {
    @Override
    public BookDto convert(Book model) {
        return BookDto.builder()
                .title(model.getTitle())
                .ISBN(model.getISBN())
                .coverPrice(model.getCoverPrice())
                .image(model.getImage())
                .status(model.getStatus())
                .publishYear(model.getPublishYear())
                .build();
    }
}
