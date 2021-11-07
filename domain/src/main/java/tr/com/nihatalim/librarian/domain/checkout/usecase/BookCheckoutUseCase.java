package tr.com.nihatalim.librarian.domain.checkout.usecase;

import lombok.RequiredArgsConstructor;

import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserPort;
import tr.com.nihatalim.librarian.domain.book.model.BookDetail;
import tr.com.nihatalim.librarian.domain.book.model.BookStatus;
import tr.com.nihatalim.librarian.domain.book.port.GetBookDetailPort;
import tr.com.nihatalim.librarian.domain.checkout.converter.CheckoutConverter;
import tr.com.nihatalim.librarian.domain.checkout.dto.request.BookCheckoutRequest;
import tr.com.nihatalim.librarian.domain.checkout.dto.response.CheckoutDto;
import tr.com.nihatalim.librarian.domain.checkout.exception.BookAlreadyCheckedOutException;
import tr.com.nihatalim.librarian.domain.checkout.model.Checkout;
import tr.com.nihatalim.librarian.domain.checkout.port.BookCheckoutPort;
import tr.com.nihatalim.librarian.domain.checkout.port.CheckUserIsNotOperatorPort;
import tr.com.nihatalim.librarian.domain.common.usecase.FunctionalUseCase;

import java.math.BigDecimal;
import java.util.Date;

@RequiredArgsConstructor
public class BookCheckoutUseCase implements FunctionalUseCase<BookCheckoutRequest, CheckoutDto> {
    private final GetUserPort getUserPort;
    private final CheckUserIsNotOperatorPort checkUserIsNotOperatorPort;
    private final GetBookDetailPort getBookDetailPort;
    private final BookCheckoutPort bookCheckoutPort;
    private final CheckoutConverter checkoutConverter;

    @Override
    public synchronized CheckoutDto apply(BookCheckoutRequest request) {
        // Get user and validate the user has been exists
        LibraryUser user = getUserPort.getUser(request.getUsername());

        // Check the user is not operated user
        checkUserIsNotOperatorPort.checkUser(user.getName());

        // Get book and validate the book has been exists
        BookDetail bookDetail = getBookDetailPort.getBookDetail(request.getBookId());

        // Check the book is not checked out
        if (bookDetail.getStatus() == BookStatus.CHECK_OUT) {
            throw new BookAlreadyCheckedOutException();
        }

        // Checkout the book for the user
        Checkout checkout = Checkout.builder()
            .bookId(bookDetail.getId())
            .username(user.getName())
            .status(bookDetail.getStatus())
            .mobileNumber(request.getMobileNumber())
            .nationalId(request.getNationalId())
            .checkoutDate(new Date())
            .returnDate(new Date(System.currentTimeMillis() + 15 * 24 * 60 * 60 * 1000))
            .penalty(BigDecimal.ZERO)
            .build();

        checkout = bookCheckoutPort.checkoutBook(checkout);

        return checkoutConverter.convert(checkout);
    }
}
