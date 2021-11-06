package tr.com.nihatalim.librarian.infra.common.rest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import tr.com.nihatalim.librarian.infra.common.rest.response.BaseResponse;
import tr.com.nihatalim.librarian.infra.common.rest.util.ResponseUtil;

import java.util.Objects;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse> baseExceptionHandler(BaseException exception, WebRequest request) {
        return ResponseUtil.error(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleMethodArgumentException(MethodArgumentNotValidException ex, WebRequest request) {
        String errorMessage = "Bad parameter!";

        FieldError fieldError = ex.getFieldError();

        if(Objects.nonNull(fieldError)) {
            errorMessage = fieldError.getDefaultMessage();
        }

        return ResponseUtil.error(null, errorMessage);
    }
}