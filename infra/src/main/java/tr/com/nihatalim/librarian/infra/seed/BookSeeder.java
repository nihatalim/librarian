package tr.com.nihatalim.librarian.infra.seed;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tr.com.nihatalim.librarian.domain.book.model.BookStatus;
import tr.com.nihatalim.librarian.infra.book.persistence.entity.BookEntity;
import tr.com.nihatalim.librarian.infra.book.persistence.repository.BookRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class BookSeeder implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            List<BookEntity> bookEntities = generateBooks(20);
            bookRepository.saveAll(bookEntities);
        }
    }

    private List<BookEntity> generateBooks(int count) {
        List<BookEntity> books = IntStream.range(0, count)
            .mapToObj(item -> {
                BookEntity bookEntity = new BookEntity();
                bookEntity.setTitle("Book " + item);
                bookEntity.setImage("image url " + item);
                bookEntity.setCoverPrice(BigDecimal.valueOf(item));
                bookEntity.setISBN("ISBN-12-34-" + item);
                bookEntity.setPublishYear(2000 + item);
                bookEntity.setStatus(BookStatus.CHECK_IN);
                return bookEntity;
            }).collect(Collectors.toList());

        return books;
    }
}
