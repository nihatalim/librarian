package tr.com.nihatalim.librarian.infra.checkout.adapter;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.checkout.model.Checkout;
import tr.com.nihatalim.librarian.domain.checkout.port.GetLastBookCheckoutPort;
import tr.com.nihatalim.librarian.infra.checkout.converter.EntityCheckoutConverter;
import tr.com.nihatalim.librarian.infra.checkout.persistence.entity.CheckoutEntity;
import tr.com.nihatalim.librarian.infra.checkout.persistence.repository.CheckoutRepository;

@Component
@RequiredArgsConstructor
public class GetLastBookCheckoutAdapter implements GetLastBookCheckoutPort {
    private final CheckoutRepository checkoutRepository;
    private final EntityCheckoutConverter entityCheckoutConverter;

    @Override
    public Checkout getLastCheckout(Long bookId) {
        final CheckoutEntity lastCheckout = checkoutRepository.getLastCheckout(bookId);
        return entityCheckoutConverter.convert(lastCheckout);
    }
}
