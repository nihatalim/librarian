package tr.com.nihatalim.librarian.infra.book.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import tr.com.nihatalim.librarian.infra.book.persistence.entity.BookEntity;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> getBookById(Long id);
}
