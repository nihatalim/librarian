package tr.com.nihatalim.librarian.domain.book.usecase;

import lombok.RequiredArgsConstructor;

import tr.com.nihatalim.librarian.domain.book.converter.BookDetailDtoConverter;
import tr.com.nihatalim.librarian.domain.book.dto.response.BookDetailDto;
import tr.com.nihatalim.librarian.domain.book.port.GetBookDetailPort;
import tr.com.nihatalim.librarian.domain.common.usecase.FunctionalUseCase;

@RequiredArgsConstructor
public class BookDetailUseCase implements FunctionalUseCase<Long, BookDetailDto> {
    private final GetBookDetailPort getBookDetailPort;
    private final BookDetailDtoConverter bookDetailDtoConverter;

    @Override
    public BookDetailDto apply(Long bookId) {
        return bookDetailDtoConverter.convert(getBookDetailPort.getBookDetail(bookId));
    }
}
