package tr.com.nihatalim.librarian.infra.checkout.rest.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.nihatalim.librarian.domain.checkout.dto.request.BookCheckoutRequest;
import tr.com.nihatalim.librarian.domain.checkout.usecase.BookCheckoutUseCase;
import tr.com.nihatalim.librarian.infra.common.rest.response.BaseResponse;
import tr.com.nihatalim.librarian.infra.common.rest.util.ResponseUtil;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/checkout")
@RequiredArgsConstructor
public class CheckoutController {
    private final BookCheckoutUseCase bookCheckoutUseCase;

    @PostMapping
    public ResponseEntity<BaseResponse> checkout(@RequestBody @Valid BookCheckoutRequest request) {
        return ResponseUtil.ok(bookCheckoutUseCase.apply(request));
    }
}
