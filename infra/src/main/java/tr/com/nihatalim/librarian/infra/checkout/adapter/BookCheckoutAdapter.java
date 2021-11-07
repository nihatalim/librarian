package tr.com.nihatalim.librarian.infra.checkout.adapter;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.checkout.model.Checkout;
import tr.com.nihatalim.librarian.domain.checkout.port.BookCheckoutPort;
import tr.com.nihatalim.librarian.infra.checkout.converter.CheckoutEntityConverter;
import tr.com.nihatalim.librarian.infra.checkout.converter.EntityCheckoutConverter;
import tr.com.nihatalim.librarian.infra.checkout.persistence.entity.CheckoutEntity;
import tr.com.nihatalim.librarian.infra.checkout.persistence.repository.CheckoutRepository;

@Component
@RequiredArgsConstructor
public class BookCheckoutAdapter implements BookCheckoutPort {
    private final CheckoutRepository checkoutRepository;
    private final CheckoutEntityConverter checkoutEntityConverter;
    private final EntityCheckoutConverter entityCheckoutConverter;

    @Override
    public Checkout checkoutBook(Checkout checkout) {
        CheckoutEntity checkoutEntity = checkoutEntityConverter.convert(checkout);

        checkoutEntity = checkoutRepository.saveAndFlush(checkoutEntity);

        return entityCheckoutConverter.convert(checkoutEntity);
    }
}
