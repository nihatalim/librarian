package tr.com.nihatalim.librarian.domain.checkout.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import tr.com.nihatalim.librarian.domain.book.model.BookStatus;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckoutDto {
    private String username;
    private Long bookId;
    private BookStatus status;
    private String mobileNumber;
    private Long nationalId;
    private Date checkoutDate;
    private Date returnDate;
    private BigDecimal penalty;
}
