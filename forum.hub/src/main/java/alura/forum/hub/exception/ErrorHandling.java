package alura.forum.hub.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleError400(MethodArgumentNotValidException e){
        List<FieldError> errors = e.getFieldErrors();
        
        return ResponseEntity.badRequest().body(errors.stream().map(ValidationErrorData::new).toList());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handleError500Resp(SQLIntegrityConstraintViolationException e){            
        return ResponseEntity.badRequest().body(new ValidationErrorData(e.getLocalizedMessage(), "Já existe um tópico e uma mensagem iguais."));
    }

    private record ValidationErrorData (String field, String message) {
        public ValidationErrorData(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
