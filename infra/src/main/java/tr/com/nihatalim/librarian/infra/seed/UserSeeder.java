package tr.com.nihatalim.librarian.infra.seed;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.infra.auth.persistence.entity.LibraryUserEntity;
import tr.com.nihatalim.librarian.infra.auth.persistence.repository.LibraryUserRepository;
import tr.com.nihatalim.librarian.infra.util.EncoderFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserSeeder implements CommandLineRunner {
    private final LibraryUserRepository repository;
    private final EncoderFactory encoderFactory;

    @Override
    public void run(String... args) throws Exception {
        final LibraryUserEntity libraryUserEntity = generateLibraryUser();
        final LibraryUserEntity librarianUserEntity = generateLibrarianUser();

        if (repository.count() == 0) {
            repository.saveAll(Arrays.asList(libraryUserEntity, librarianUserEntity));
        }
    }

    private LibraryUserEntity generateLibrarianUser() {
        LibraryUserEntity libraryUserEntity = new LibraryUserEntity();
        libraryUserEntity.setUsername("librarian");
        libraryUserEntity.setPassword(encoderFactory.hash("1234"));
        libraryUserEntity.setCreatedAt(new Date());
        libraryUserEntity.setUpdatedAt(new Date());

        return libraryUserEntity;
    }

    private LibraryUserEntity generateLibraryUser() {
        LibraryUserEntity libraryUserEntity = new LibraryUserEntity();
        libraryUserEntity.setUsername("nihatalim");
        libraryUserEntity.setPassword(encoderFactory.hash("1234"));
        libraryUserEntity.setCreatedAt(new Date());
        libraryUserEntity.setUpdatedAt(new Date());

        return libraryUserEntity;
    }
}
