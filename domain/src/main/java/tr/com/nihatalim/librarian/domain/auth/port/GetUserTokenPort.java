package tr.com.nihatalim.librarian.domain.auth.port;

public interface GetUserTokenPort {
    String getTokenByUserName(String username);
}
