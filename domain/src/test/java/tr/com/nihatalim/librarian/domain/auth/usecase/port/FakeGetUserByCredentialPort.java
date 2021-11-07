package tr.com.nihatalim.librarian.domain.auth.usecase.port;

import tr.com.nihatalim.librarian.domain.auth.exception.UserCredentialsNotValidException;
import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserByCredentialPort;

import java.util.Arrays;
import java.util.List;

public class FakeGetUserByCredentialPort implements GetUserByCredentialPort {
    private List<LibraryUser> libraryUsers = Arrays.asList(LibraryUser.builder().name("nihatalim").password("1234").build());

    @Override
    public LibraryUser getUser(String username, String password) {
        return libraryUsers.stream().filter(user -> user.getName().equals(username))
                .filter(user -> user.getPassword().equals(password))
                .findFirst()
                .orElseThrow(UserCredentialsNotValidException::new);
    }
}
