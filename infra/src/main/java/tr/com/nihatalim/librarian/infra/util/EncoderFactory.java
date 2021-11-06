package tr.com.nihatalim.librarian.infra.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class EncoderFactory {
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean check(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
