package pe.edu.upc.schoolblog.shared.exception;

import jakarta.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;
import java.util.stream.Collectors;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceInternalServerErrorException extends RuntimeException {

    public <T> ResourceInternalServerErrorException(Set<ConstraintViolation<T>> violations){
        super(violations.stream()
                .map(violation -> String.format("%s : %s", violation.getPropertyPath(), violation.getMessage()))
                .collect(Collectors.joining(", ")));
        StackTraceElement[] mio = {};
        this.setStackTrace(mio);
    }
}
