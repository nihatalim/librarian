package tr.com.nihatalim.librarian.domain.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tr.com.nihatalim.librarian.domain.common.model.BaseModel;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BookDetail extends BaseModel {
    private String title;
    private String ISBN;
    private Integer publishYear;
    private BigDecimal coverPrice;
    private String image;
    private BookStatus status;
    private String checkedUser;
}
