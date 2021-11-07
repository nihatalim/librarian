package tr.com.nihatalim.librarian.domain.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.nihatalim.librarian.domain.book.model.BookStatus;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDetailDto {
    private String title;
    private String ISBN;

    private Integer publishYear;
    private BigDecimal coverPrice;

    private String image;

    private BookStatus status;

    private String checkedUser;
}
