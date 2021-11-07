package tr.com.nihatalim.librarian.infra.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import tr.com.nihatalim.librarian.infra.auth.service.UserDetailServiceImpl;
import tr.com.nihatalim.librarian.infra.common.rest.filter.JwtProperties;
import tr.com.nihatalim.librarian.infra.common.rest.filter.JwtRequestFilter;
import tr.com.nihatalim.librarian.infra.common.rest.filter.JwtRequestVerifier;

import javax.crypto.SecretKey;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailServiceImpl userDetailsService;

    private final JwtProperties jwtProperties;

    private final SecretKey secretKey;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests().antMatchers("/auth").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilter(new JwtRequestFilter(authenticationManager(), jwtProperties, secretKey))
            .addFilterAfter(new JwtRequestVerifier(secretKey,jwtProperties),JwtRequestFilter.class)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
