package tr.com.nihatalim.librarian.infra.common.rest.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tr.com.nihatalim.librarian.domain.auth.dto.request.LoginRequest;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@RequiredArgsConstructor
public class JwtRequestFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private final JwtProperties jwtProperties;

    private final SecretKey secretKey;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException
    {
        try {

            LoginRequest loginRequest = new ObjectMapper().readValue(
                request.getInputStream(),
                LoginRequest.class
            );

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
            );

            Authentication authenticate = authenticationManager.authenticate(authentication);

            return authenticate;
        }
        catch (IOException e) {
            throw new RuntimeException(String.format("Bad Request"));
        }

    }

    @Override
    protected void successfulAuthentication(
        HttpServletRequest request, HttpServletResponse response,
        FilterChain chain, Authentication authResult) throws IOException, ServletException
    {

        String token = Jwts.builder()
            .setSubject(authResult.getName())
            .claim(jwtProperties.getAuthoritiesClaimKey(),authResult.getAuthorities())
            .setIssuedAt(new Date())
            .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtProperties.getTokenExpirationAfterDays())))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();

        response.addHeader(jwtProperties.getAuthorizationHeader(), jwtProperties.getTokenPrefix() + token);
    }
}
