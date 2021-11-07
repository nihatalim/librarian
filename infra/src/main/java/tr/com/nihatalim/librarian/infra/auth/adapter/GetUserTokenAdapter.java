package tr.com.nihatalim.librarian.infra.auth.adapter;

import io.jsonwebtoken.Jwts;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.auth.port.GetUserTokenPort;
import tr.com.nihatalim.librarian.infra.common.rest.filter.JwtProperties;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class GetUserTokenAdapter implements GetUserTokenPort {
    private final JwtProperties jwtProperties;
    private final SecretKey secretKey;

    @Override
    public String getTokenByUserName(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .claim(jwtProperties.getAuthoritiesClaimKey(), Collections.emptyList())
            .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtProperties.getTokenExpirationAfterDays())))
            .signWith(secretKey)
            .compact();
    }
}
