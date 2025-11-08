package com.example.dddbackend.common.exception;


import com.example.domain.common.exception.BadRequestException;
import com.example.domain.common.exception.ClientBusinessException;
import com.example.domain.common.exception.ResoureNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ResoureNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleException(ResoureNotFoundException e) {
        log.warn(e.getMessage(), e);
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getErrorCode().getDetailMessage());
        problemDetail.setProperty("message", e.getMessage());
        return ResponseEntity.status(problemDetail.getStatus())
                .body(problemDetail);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ProblemDetail> handleException(BadRequestException e) {
        log.warn(e.getMessage(), e);
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getErrorCode().getDetailMessage());
        problemDetail.setProperty("message", e.getMessage());
        return ResponseEntity.status(problemDetail.getStatus())
                .body(problemDetail);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ProblemDetail> handleException(Exception e) {
        log.error(e.getMessage(), e);
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        problemDetail.setProperty("message", "서버 오류입니다.");
        return ResponseEntity.status(problemDetail.getStatus())
                .body(problemDetail);
    }


}
