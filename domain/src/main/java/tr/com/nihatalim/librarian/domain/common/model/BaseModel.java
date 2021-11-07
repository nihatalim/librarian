package tr.com.nihatalim.librarian.domain.common.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
