package tr.com.nihatalim.librarian.domain.checkout.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.experimental.SuperBuilder;
import tr.com.nihatalim.librarian.domain.book.model.BookStatus;
import tr.com.nihatalim.librarian.domain.common.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Checkout extends BaseModel {
    private String username;
    private Long bookId;
    private BookStatus status;
    private String mobileNumber;
    private Long nationalId;
    private Date checkoutDate;
    private Date returnDate;
    private BigDecimal penalty;
}
