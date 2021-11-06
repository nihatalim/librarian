package tr.com.nihatalim.librarian.infra.auth.rest.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import tr.com.nihatalim.librarian.domain.auth.dto.request.LoginRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.nihatalim.librarian.domain.auth.usecase.AuthUseCase;
import tr.com.nihatalim.librarian.infra.common.rest.response.BaseResponse;
import tr.com.nihatalim.librarian.infra.common.rest.util.ResponseUtil;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthUseCase authUseCase;

    @PostMapping
    public ResponseEntity<BaseResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseUtil.ok(authUseCase.apply(request));
    }
}
