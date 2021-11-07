package tr.com.nihatalim.librarian.infra.checkout.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.experimental.SuperBuilder;
import tr.com.nihatalim.librarian.domain.book.model.BookStatus;
import tr.com.nihatalim.librarian.infra.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CHECKOUT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CheckoutEntity extends BaseEntity {
    @Column(name = "username")
    private String username;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "status")
    private BookStatus status;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "national_id")
    private Long nationalId;

    @Column(name = "checkout_date")
    private Date checkoutDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "penalty")
    private BigDecimal penalty;
}
