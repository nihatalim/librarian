package tr.com.nihatalim.librarian.infra.auth.config;

import tr.com.nihatalim.librarian.domain.auth.port.GetUserByCredentialPort;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserTokenPort;
import tr.com.nihatalim.librarian.domain.auth.usecase.AuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AuthConfig {
    private final GetUserByCredentialPort getUserByCredentialPort;
    private final GetUserTokenPort getUserTokenPort;

    @Bean
    public AuthUseCase authUseCase() {
        return new AuthUseCase(getUserByCredentialPort, getUserTokenPort);
    }
}
