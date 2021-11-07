package tr.com.nihatalim.librarian.domain.book.converter;

import tr.com.nihatalim.librarian.domain.book.dto.response.BookDetailDto;
import tr.com.nihatalim.librarian.domain.book.model.BookDetail;
import tr.com.nihatalim.librarian.domain.common.converter.BaseConverter;

public class BookDetailDtoConverter implements BaseConverter<BookDetail, BookDetailDto> {
    @Override
    public BookDetailDto convert(BookDetail model) {
        return BookDetailDto.builder()
            .title(model.getTitle())
            .ISBN(model.getISBN())
            .coverPrice(model.getCoverPrice())
            .image(model.getImage())
            .status(model.getStatus())
            .publishYear(model.getPublishYear())
            .checkedUser(model.getCheckedUser())
            .build();
    }
}
