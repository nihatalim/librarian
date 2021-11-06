package tr.com.nihatalim.librarian.domain.auth.usecase.port;

import tr.com.nihatalim.librarian.domain.auth.port.GetUserTokenPort;

public class FakeGetUserTokenPort implements GetUserTokenPort {
    @Override
    public String getTokenByUserName(String username) {
        return "Token created for " + username;
    }
}
