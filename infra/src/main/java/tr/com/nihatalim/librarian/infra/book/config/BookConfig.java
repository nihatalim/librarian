package tr.com.nihatalim.librarian.infra.book.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tr.com.nihatalim.librarian.domain.book.converter.BookDtoConverter;
import tr.com.nihatalim.librarian.domain.book.port.GetBooksPort;
import tr.com.nihatalim.librarian.domain.book.usecase.ListBooksUseCase;

@Configuration
@RequiredArgsConstructor
public class BookConfig {
    private final GetBooksPort getBooksPort;

    @Bean
    public BookDtoConverter bookDtoConverter() {
        return new BookDtoConverter();
    }

    @Bean
    public ListBooksUseCase listBooksUseCase() {
        return new ListBooksUseCase(getBooksPort, bookDtoConverter());
    }
}
