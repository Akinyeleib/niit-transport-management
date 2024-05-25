package competition.transport.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> badRequest(BadRequestException exception, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage.getMessage());
    }

    @ExceptionHandler(NotFoundRequestException.class)
    public ResponseEntity<String> notFoundRequest(NotFoundRequestException exception, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage.getMessage());
    }

    @ExceptionHandler(DuplicateRequestException.class)
    public ResponseEntity<String> duplicateRequest(DuplicateRequestException exception, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> genericException(Exception exception, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage.getMessage());
    }

}
