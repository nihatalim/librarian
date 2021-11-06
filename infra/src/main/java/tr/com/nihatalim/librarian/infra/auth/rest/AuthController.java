package tr.com.nihatalim.librarian.infra.auth.rest;

import tr.com.nihatalim.librarian.domain.auth.dto.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.nihatalim.librarian.infra.util.rest.response.BaseResponse;
import tr.com.nihatalim.librarian.infra.util.rest.response.ResponseUtil;

@RestController
@RequestMapping("/tr/com/nihatalim/librarian/domain/auth")
public class AuthController {

    @PostMapping
    public ResponseEntity<BaseResponse> login(LoginRequest request) {
        return ResponseUtil.ok();
    }
}
