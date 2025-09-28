package camati.example.user_management_rbac.adapters.rest.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // Erros de validação
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }

  // Erros de negócio
  // @ExceptionHandler(BusinessException.class)
  // public ResponseEntity<Map<String, String>> handleBusinessExceptions(BusinessException ex) {
  //   Map<String, String> error = new HashMap<>();
  //   error.put("error", ex.getMessage());
  //   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  // }

  // Erros genéricos
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, String>> handleGenericExceptions(Exception ex) {
    Map<String, String> error = new HashMap<>();
    error.put("error", "Erro interno do servidor");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}