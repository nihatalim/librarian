package tr.com.nihatalim.librarian.infra.auth.adapter;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserByCredentialPort;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserPort;
import tr.com.nihatalim.librarian.infra.auth.rest.exception.UserCredentialsNotValidException;

@Component
@RequiredArgsConstructor
public class GetUserByCredentialAdapter implements GetUserByCredentialPort {
    private final GetUserPort getUserPort;

    @Override
    public LibraryUser getUser(String username, String password) {
        LibraryUser user = getUserPort.getUser(username);

        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new UserCredentialsNotValidException();
        }

        return user;
    }
}
