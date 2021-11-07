package tr.com.nihatalim.librarian.infra.book.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tr.com.nihatalim.librarian.domain.book.converter.BookDetailDtoConverter;
import tr.com.nihatalim.librarian.domain.book.converter.BookDtoConverter;
import tr.com.nihatalim.librarian.domain.book.port.GetBookDetailPort;
import tr.com.nihatalim.librarian.domain.book.port.GetBooksPort;
import tr.com.nihatalim.librarian.domain.book.usecase.BookDetailUseCase;
import tr.com.nihatalim.librarian.domain.book.usecase.ListBooksUseCase;

@Configuration
@RequiredArgsConstructor
public class BookConfig {
    private final GetBooksPort getBooksPort;
    private final GetBookDetailPort getBookDetailPort;

    @Bean
    public BookDtoConverter bookDtoConverter() {
        return new BookDtoConverter();
    }

    @Bean
    public ListBooksUseCase listBooksUseCase() {
        return new ListBooksUseCase(getBooksPort, bookDtoConverter());
    }

    @Bean
    public BookDetailDtoConverter bookDetailDtoConverter() {
        return new BookDetailDtoConverter();
    }

    @Bean
    public BookDetailUseCase bookDetailUseCase() {
        return new BookDetailUseCase(getBookDetailPort, bookDetailDtoConverter());
    }
}
