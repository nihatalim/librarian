package tr.com.nihatalim.librarian.domain.auth.port;

import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;

import java.util.Optional;

public interface GetUserPort {
    Optional<LibraryUser> getUser(String username, String password);
}
