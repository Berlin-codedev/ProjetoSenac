package Senac.projeto.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CpfDuplicadoException.class)
    public ResponseEntity<ApiError> tratarCpfDuplicado(CpfDuplicadoException ex, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        ApiError errorCompleto = new ApiError(
                Instant.now(),
                status.value(),
                "Registro Duplicado",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(errorCompleto);
    }
}
