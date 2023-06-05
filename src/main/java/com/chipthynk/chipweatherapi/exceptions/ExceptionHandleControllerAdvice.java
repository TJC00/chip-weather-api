package com.chipthynk.chipweatherapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandleControllerAdvice {
    @ExceptionHandler(WeatherDetailsFailedLoading.class)
    public ProblemDetail weatherDetailsFailedLoading(WeatherDetailsFailedLoading weatherDetailsFailedLoading){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.REQUEST_TIMEOUT, weatherDetailsFailedLoading.getMessage());
        problemDetail.setTitle("Failed Loading");
        return problemDetail;
    }

    @ExceptionHandler(WeatherSummaryExceptionHandler.class)
    public ProblemDetail weatherSummaryExceptionHandler(WeatherSummaryExceptionHandler exceptionHandler){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exceptionHandler.getMessage());
        problemDetail.setTitle("Failed To Load Summary");

        return problemDetail;
    }
}
