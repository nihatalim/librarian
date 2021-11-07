package tr.com.nihatalim.librarian.domain.book.port;

import tr.com.nihatalim.librarian.domain.book.model.BookDetail;

public interface GetBookDetailPort {
    BookDetail getBookDetail(Long bookId);
}
