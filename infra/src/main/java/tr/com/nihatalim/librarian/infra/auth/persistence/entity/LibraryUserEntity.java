package tr.com.nihatalim.librarian.infra.auth.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.nihatalim.librarian.infra.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY_USER")
@Getter
@Setter
@NoArgsConstructor
public class LibraryUserEntity extends BaseEntity {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
