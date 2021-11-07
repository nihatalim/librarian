package tr.com.nihatalim.librarian.infra.book.adapter;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.book.model.BookDetail;
import tr.com.nihatalim.librarian.domain.book.model.BookStatus;
import tr.com.nihatalim.librarian.domain.book.port.GetBookDetailPort;
import tr.com.nihatalim.librarian.domain.checkout.model.Checkout;
import tr.com.nihatalim.librarian.domain.checkout.port.GetLastBookCheckoutPort;
import tr.com.nihatalim.librarian.infra.book.persistence.entity.BookEntity;
import tr.com.nihatalim.librarian.infra.book.persistence.repository.BookRepository;
import tr.com.nihatalim.librarian.infra.book.rest.controller.exception.BookNotFoundException;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetBookDetailAdapter implements GetBookDetailPort {
    private final BookRepository bookRepository;
    private final GetLastBookCheckoutPort getLastBookCheckoutPort;

    @Override
    public BookDetail getBookDetail(Long bookId) {
        Optional<BookEntity> book = bookRepository.getBookById(bookId);

        if (!book.isPresent()) {
            throw new BookNotFoundException();
        }

        final BookEntity bookEntity = book.get();
        final BookDetail bookDetail = BookDetail.builder()
            .title(bookEntity.getTitle())
            .ISBN(bookEntity.getISBN())
            .coverPrice(bookEntity.getCoverPrice())
            .image(bookEntity.getImage())
            .status(bookEntity.getStatus())
            .publishYear(bookEntity.getPublishYear())
            .build();

        if (bookEntity.getStatus() == BookStatus.CHECK_OUT) {
            Checkout lastCheckout = getLastBookCheckoutPort.getLastCheckout(bookId);
            bookDetail.setCheckedUser(lastCheckout.getUsername());
        }

        return bookDetail;
    }
}
