package tr.com.nihatalim.librarian.infra.auth.adapter;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserPort;
import tr.com.nihatalim.librarian.infra.auth.converter.LibraryUserConverter;
import tr.com.nihatalim.librarian.infra.auth.persistence.repository.LibraryUserRepository;
import tr.com.nihatalim.librarian.infra.auth.rest.exception.UserNotFoundException;

@Component
@RequiredArgsConstructor
public class GetUserAdapter implements GetUserPort {
    private final LibraryUserRepository libraryUserRepository;
    private final LibraryUserConverter libraryUserConverter;

    @Override
    public LibraryUser getUser(String username) {
        return libraryUserRepository.getLibraryUserEntityByUsername(username)
            .map(libraryUserConverter::convert)
            .orElseThrow(UserNotFoundException::new);
    }
}
