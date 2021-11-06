package tr.com.nihatalim.librarian.infra.auth.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.nihatalim.librarian.infra.auth.persistence.entity.LibraryUserEntity;

import java.util.Optional;

@Repository
public interface LibraryUserRepository extends JpaRepository<LibraryUserEntity, Long> {
    Optional<LibraryUserEntity> getLibraryUserEntityByUsername(String username);
}
