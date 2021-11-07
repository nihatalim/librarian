package tr.com.nihatalim.librarian.domain.auth.port;

import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;

public interface GetUserByCredentialPort {
    LibraryUser getUser(String username, String password);
}
