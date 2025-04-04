package com.example.marcybackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    // S'occupe des erreurs devant retourner le statut 400.
    @ExceptionHandler({
            IllegalArgumentException.class,
            InvalidDataException.class
    })
    public ResponseEntity<ApiException> handleInvalidDataException(Exception e) {
        ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage(), e.getClass().getSimpleName());
        return apiException.toResponseEntity();
    }

    // S'occupe des erreurs devant retourner le statut 404.
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiException> handleNotFoundException(Exception e) {
        ApiException apiException = new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), e.getClass().getSimpleName());
        return apiException.toResponseEntity();
    }

    // Erreur 500 lorsqu'il s'agit d'une exception non gérée.
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiException> handleException(Exception e) {
        ApiException apiException = new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e.getClass().getSimpleName());
        return apiException.toResponseEntity();
    }
}
