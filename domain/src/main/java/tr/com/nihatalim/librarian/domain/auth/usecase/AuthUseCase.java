package tr.com.nihatalim.librarian.domain.auth.usecase;

import tr.com.nihatalim.librarian.domain.auth.dto.request.LoginRequest;
import tr.com.nihatalim.librarian.domain.auth.dto.response.LoginResponse;
import tr.com.nihatalim.librarian.domain.auth.exception.UserCredentialsNotValidException;
import tr.com.nihatalim.librarian.domain.auth.model.LibraryUser;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserPort;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserTokenPort;
import tr.com.nihatalim.librarian.domain.common.usecase.FunctionalUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthUseCase implements FunctionalUseCase<LoginRequest, LoginResponse> {
    private final GetUserPort getUserPort;
    private final GetUserTokenPort getUserTokenPort;

    @Override
    public LoginResponse apply(LoginRequest loginRequest) {
        final LibraryUser user = getUserPort
                .getUser(loginRequest.getUsername(), loginRequest.getPassword())
                .orElseThrow(UserCredentialsNotValidException::new);

        final String token = getUserTokenPort.getTokenByUserName(user.getName());

        return new LoginResponse(token);
    }
}
