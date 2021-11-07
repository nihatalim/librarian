package tr.com.nihatalim.librarian.domain.checkout.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCheckoutRequest {
    @NotNull
    private Long bookId;

    @NotBlank
    private String username;

    @Pattern(regexp = "/^(\\d{2})-(\\d{3})-(\\d{4})/g")
    private String mobileNumber;

    @Digits(integer = 11, fraction = 0)
    private Long nationalId;

    @NotNull
    private Date checkoutDate;
}
