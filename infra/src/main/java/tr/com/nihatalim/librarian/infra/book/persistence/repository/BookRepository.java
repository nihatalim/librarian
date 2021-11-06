package tr.com.nihatalim.librarian.infra.book.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.nihatalim.librarian.infra.book.persistence.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
