package tr.com.nihatalim.librarian.infra.util.rest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tr.com.nihatalim.librarian.backend.util.rest.exception.BaseException;

public class ResponseUtil {

    public static ResponseEntity<BaseResponse> ok() {
        return new ResponseEntity<>(ResponseUtil.body(null, "OK"), HttpStatus.OK);
    }

    public static ResponseEntity<BaseResponse> ok(Object data, String status) {
        return new ResponseEntity<>(ResponseUtil.body(data, status), HttpStatus.OK);
    }

    public static ResponseEntity<BaseResponse> ok(Object data) {
        return new ResponseEntity<>(ResponseUtil.body(data, "OK"), HttpStatus.OK);
    }

    public static BaseResponse body(Object data, String status) {
        return new BaseResponse(data, status);
    }

    public static ResponseEntity<BaseResponse> error() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<BaseResponse> error(Object data, String status) {
        return new ResponseEntity<>(ResponseUtil.body(data, status), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<BaseResponse> error(BaseException exception) {
        return new ResponseEntity<>(ResponseUtil.body(null, exception.getMessage()), exception.getHttpStatus());
    }
}
