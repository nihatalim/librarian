package tr.com.nihatalim.librarian.infra.checkout.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tr.com.nihatalim.librarian.domain.auth.port.GetUserPort;
import tr.com.nihatalim.librarian.domain.book.port.GetBookDetailPort;
import tr.com.nihatalim.librarian.domain.checkout.converter.CheckoutConverter;
import tr.com.nihatalim.librarian.domain.checkout.port.BookCheckoutPort;
import tr.com.nihatalim.librarian.domain.checkout.port.CheckUserIsNotOperatorPort;
import tr.com.nihatalim.librarian.domain.checkout.usecase.BookCheckoutUseCase;

@Configuration
@RequiredArgsConstructor
public class CheckoutConfig {
    private final GetUserPort getUserPort;
    private final CheckUserIsNotOperatorPort checkUserIsNotOperatorPort;
    private final GetBookDetailPort getBookDetailPort;
    private final BookCheckoutPort bookCheckoutPort;

    @Bean
    public CheckoutConverter checkoutConverter() {
        return new CheckoutConverter();
    }

    @Bean
    public BookCheckoutUseCase bookCheckoutUseCase() {
        return new BookCheckoutUseCase(getUserPort, checkUserIsNotOperatorPort, getBookDetailPort, bookCheckoutPort, checkoutConverter());
    }
}
