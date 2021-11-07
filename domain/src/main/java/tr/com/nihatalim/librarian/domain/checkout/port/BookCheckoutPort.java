package tr.com.nihatalim.librarian.domain.checkout.port;

import tr.com.nihatalim.librarian.domain.checkout.model.Checkout;

public interface BookCheckoutPort {
    Checkout checkoutBook(Checkout checkout);
}
