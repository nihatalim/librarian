package tr.com.nihatalim.librarian.domain.auth.usecase;

import org.junit.jupiter.api.Test;

import tr.com.nihatalim.librarian.domain.auth.dto.request.LoginRequest;
import tr.com.nihatalim.librarian.domain.auth.dto.response.LoginResponse;
import tr.com.nihatalim.librarian.domain.auth.exception.UserCredentialsNotValidException;
import tr.com.nihatalim.librarian.domain.auth.usecase.port.FakeGetUserByCredentialPort;
import tr.com.nihatalim.librarian.domain.auth.usecase.port.FakeGetUserTokenPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AuthUseCaseTest {
    private final AuthUseCase authUseCase = new AuthUseCase(new FakeGetUserByCredentialPort(), new FakeGetUserTokenPort());

    @Test
    void whenUserCredentialsNotValid_thenThrowException() {
        LoginRequest loginRequest = new LoginRequest("nihat", "1234");

        assertThrows(UserCredentialsNotValidException.class, () -> authUseCase.apply(loginRequest));
    }

    @Test
    void whenUserCredentialsValid_thenReturnToken() {
        LoginRequest loginRequest = new LoginRequest("nihatalim", "1234");
        LoginResponse loginResponse = authUseCase.apply(loginRequest);

        assertEquals("Token created for nihatalim", loginResponse.getToken());
    }

}