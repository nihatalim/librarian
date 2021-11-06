package tr.com.nihatalim.librarian.infra.book.rest.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.nihatalim.librarian.domain.book.usecase.ListBooksUseCase;
import tr.com.nihatalim.librarian.infra.common.rest.response.BaseResponse;
import tr.com.nihatalim.librarian.infra.common.rest.util.ResponseUtil;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final ListBooksUseCase listBooksUseCase;

    @GetMapping
    public ResponseEntity<BaseResponse> getAllBooks() {
        return ResponseUtil.ok(listBooksUseCase.get());
    }
}
