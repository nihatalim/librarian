package tr.com.nihatalim.librarian.infra.checkout.converter;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.checkout.model.Checkout;
import tr.com.nihatalim.librarian.domain.common.converter.BaseConverter;
import tr.com.nihatalim.librarian.infra.checkout.persistence.entity.CheckoutEntity;

@Component
public class CheckoutEntityConverter implements BaseConverter<Checkout, CheckoutEntity> {
    @Override
    public CheckoutEntity convert(Checkout model) {
        return CheckoutEntity.builder()
            .id(model.getId())
            .createdAt(model.getCreatedAt())
            .updatedAt(model.getUpdatedAt())
            .bookId(model.getId())
            .username(model.getUsername())
            .status(model.getStatus())
            .mobileNumber(model.getMobileNumber())
            .nationalId(model.getNationalId())
            .checkoutDate(model.getCheckoutDate())
            .returnDate(model.getReturnDate())
            .penalty(model.getPenalty())
            .build();
    }
}
