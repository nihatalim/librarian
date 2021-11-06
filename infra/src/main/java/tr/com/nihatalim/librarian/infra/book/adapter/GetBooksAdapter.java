package tr.com.nihatalim.librarian.infra.book.adapter;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.book.model.Book;
import tr.com.nihatalim.librarian.domain.book.port.GetBooksPort;
import tr.com.nihatalim.librarian.infra.book.converter.BookConverter;
import tr.com.nihatalim.librarian.infra.book.persistence.repository.BookRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetBooksAdapter implements GetBooksPort {
    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    @Override
    public List<Book> getAllBooks() {
        return bookConverter.convert(bookRepository.findAll());
    }
}
