package tr.com.nihatalim.librarian.infra.checkout.adapter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.checkout.port.CheckUserIsNotOperatorPort;
import tr.com.nihatalim.librarian.infra.checkout.rest.exception.UserCannotBeOperatorException;

@Component
public class CheckUserIsNotOperatorAdapter implements CheckUserIsNotOperatorPort {

    @Override
    public void checkUser(String username) {
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();

        if (details.getUsername().equals(username)) {
            throw new UserCannotBeOperatorException();
        }
    }
}
