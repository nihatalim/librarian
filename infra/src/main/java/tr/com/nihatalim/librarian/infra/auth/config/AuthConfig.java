package tr.com.nihatalim.librarian.infra.auth.config;

import tr.com.nihatalim.librarian.domain.auth.port.GetUserPort;
import tr.com.nihatalim.librarian.domain.auth.port.GetUserTokenPort;
import tr.com.nihatalim.librarian.domain.auth.usecase.AuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AuthConfig {
    private final GetUserPort getUserPort;
    private final GetUserTokenPort getUserTokenPort;

    @Bean
    public AuthUseCase authUseCase() {
        return new AuthUseCase(getUserPort, getUserTokenPort);
    }
}
