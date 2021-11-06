package tr.com.nihatalim.librarian.domain.book.usecase;

import lombok.RequiredArgsConstructor;

import tr.com.nihatalim.librarian.domain.book.converter.BookDtoConverter;
import tr.com.nihatalim.librarian.domain.book.dto.response.BookDto;
import tr.com.nihatalim.librarian.domain.book.port.GetBooksPort;
import tr.com.nihatalim.librarian.domain.common.usecase.SupplierUseCase;

import java.util.List;

@RequiredArgsConstructor
public class ListBooksUseCase implements SupplierUseCase<List<BookDto>> {
    private final GetBooksPort getBooksPort;
    private final BookDtoConverter bookDtoConverter;

    @Override
    public List<BookDto> get() {
        return bookDtoConverter.convert(getBooksPort.getAllBooks());
    }
}
