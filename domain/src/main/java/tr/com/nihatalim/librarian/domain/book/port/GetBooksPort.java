package tr.com.nihatalim.librarian.domain.book.port;

import tr.com.nihatalim.librarian.domain.book.model.Book;

import java.util.List;

public interface GetBooksPort {
    List<Book> getAllBooks();
}
