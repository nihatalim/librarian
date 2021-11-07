package tr.com.nihatalim.librarian.domain.checkout.converter;

import tr.com.nihatalim.librarian.domain.checkout.dto.response.CheckoutDto;
import tr.com.nihatalim.librarian.domain.checkout.model.Checkout;
import tr.com.nihatalim.librarian.domain.common.converter.BaseConverter;

public class CheckoutConverter implements BaseConverter<Checkout, CheckoutDto> {

    @Override
    public CheckoutDto convert(Checkout model) {
        return CheckoutDto.builder()
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
