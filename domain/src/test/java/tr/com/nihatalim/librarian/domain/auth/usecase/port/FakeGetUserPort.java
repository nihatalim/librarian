package tr.com.nihatalim.librarian.domain.auth.usecase.port;

import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserPort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FakeGetUserPort implements GetUserPort {
    private List<LibraryUser> libraryUsers = Arrays.asList(LibraryUser.builder().name("nihatalim").password("1234").build());

    @Override
    public Optional<LibraryUser> getUser(String username, String password) {
        return libraryUsers.stream().filter(user -> user.getName().equals(username))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }
}
