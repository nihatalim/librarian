package tr.com.nihatalim.librarian.infra.common.rest.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Getter
@Setter
public class JwtProperties {

    private String secretKey;

    private String tokenPrefix;

    private Integer tokenExpirationAfterDays;

    public String getAuthorizationHeader() {
        return "Authorization";
    }

    public String getAuthoritiesClaimKey() {
        return "authorities";
    }
}
