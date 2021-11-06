package tr.com.nihatalim.librarian.domain.book.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import tr.com.nihatalim.librarian.domain.common.usecase.model.BaseModel;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Book extends BaseModel {
    private String title;
    private String ISBN;

    private Integer publishYear;
    private BigDecimal coverPrice;

    private String image;

    private BookStatus status;
}
