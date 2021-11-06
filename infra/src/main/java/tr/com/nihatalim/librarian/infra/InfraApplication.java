package tr.com.nihatalim.librarian.infra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.com.nihatalim.librarian.infra.auth.persistence.repository.LibraryUserRepository;

@SpringBootApplication
public class InfraApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfraApplication.class, args);
    }

}
