package tr.com.nihatalim.librarian.infra.auth.adapter;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCrypt;

import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserPort;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.infra.auth.converter.LibraryUserConverter;
import tr.com.nihatalim.librarian.infra.auth.persistence.entity.LibraryUserEntity;
import tr.com.nihatalim.librarian.infra.auth.persistence.repository.LibraryUserRepository;
import tr.com.nihatalim.librarian.infra.auth.rest.exception.UserCredentialsNotValidException;
import tr.com.nihatalim.librarian.infra.auth.rest.exception.UserNotFoundException;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetUserAdapter implements GetUserPort {
    private final LibraryUserRepository libraryUserRepository;
    private final LibraryUserConverter libraryUserConverter;

    @Override
    public Optional<LibraryUser> getUser(String username, String password) {
        Optional<LibraryUserEntity> libraryUserEntity = libraryUserRepository.getLibraryUserEntityByUsername(username);

        if (!libraryUserEntity.isPresent()) {
            throw new UserNotFoundException();
        }

        LibraryUserEntity userEntity = libraryUserEntity.get();

        if (!BCrypt.checkpw(password, userEntity.getPassword())) {
            throw new UserCredentialsNotValidException();
        }

        return libraryUserEntity.map(libraryUserConverter::convert);
    }
}
