package tr.com.nihatalim.librarian.infra.book.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import tr.com.nihatalim.librarian.domain.book.model.BookStatus;
import tr.com.nihatalim.librarian.infra.book.persistence.converter.BookStatusJpaConverter;
import tr.com.nihatalim.librarian.infra.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@NoArgsConstructor
public class BookEntity extends BaseEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String ISBN;

    @Column(name = "publish_year")
    private Integer publishYear;

    @Column(name = "cover_price")
    private BigDecimal coverPrice;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    @Convert(converter = BookStatusJpaConverter.class)
    private BookStatus status;
}
