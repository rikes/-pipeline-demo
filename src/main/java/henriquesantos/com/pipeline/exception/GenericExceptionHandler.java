package henriquesantos.com.pipeline.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

/**
 * GenericExceptionHandler
 */
@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(Forbidden.class)
    public ResponseEntity<ExceptionRecord> ForbiddenException(Forbidden e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
            new ExceptionRecord(HttpStatus.FORBIDDEN, e.getMessage())
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionRecord> IllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            new ExceptionRecord(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionRecord> GeneralFailureException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ExceptionRecord(HttpStatus.NOT_FOUND, e.getMessage())
        );
    }
}