package henriquesantos.com.pipeline.exception;

import org.springframework.http.HttpStatus;

public record ExceptionRecord(HttpStatus statusCode, String message) {
    
}
