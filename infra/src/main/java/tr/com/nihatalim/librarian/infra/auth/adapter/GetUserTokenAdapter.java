package tr.com.nihatalim.librarian.infra.auth.adapter;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.auth.port.GetUserTokenPort;
import tr.com.nihatalim.librarian.infra.util.JwtUtil;

@Component
@RequiredArgsConstructor
public class GetUserTokenAdapter implements GetUserTokenPort {
    private final JwtUtil jwtUtil;

    @Override
    public String getTokenByUserName(String username) {
        return jwtUtil.generateToken(username);
    }
}
