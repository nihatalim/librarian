package tr.com.nihatalim.librarian.infra.auth.converter;

import org.springframework.stereotype.Component;
import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;
import tr.com.nihatalim.librarian.domain.common.converter.BaseConverter;
import tr.com.nihatalim.librarian.infra.auth.persistence.entity.LibraryUserEntity;

@Component
public class LibraryUserConverter implements BaseConverter<LibraryUserEntity, LibraryUser> {
    @Override
    public LibraryUser convert(LibraryUserEntity model) {
        return LibraryUser.builder().name(model.getUsername()).password(model.getPassword()).build();
    }
}
