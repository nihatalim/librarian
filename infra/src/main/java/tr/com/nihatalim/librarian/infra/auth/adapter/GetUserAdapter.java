package tr.com.nihatalim.librarian.infra.auth.adapter;

import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserAdapter implements GetUserPort {
    @Override
    public Optional<LibraryUser> getUser(String username, String password) {
        return Optional.empty();
    }
}
