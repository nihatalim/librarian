package tr.com.nihatalim.librarian.domain.checkout.port;

import tr.com.nihatalim.librarian.domain.checkout.model.Checkout;

public interface GetLastBookCheckoutPort {
    Checkout getLastCheckout(Long bookId);
}
