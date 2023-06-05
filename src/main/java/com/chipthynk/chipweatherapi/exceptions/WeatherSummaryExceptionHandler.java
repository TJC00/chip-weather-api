package com.chipthynk.chipweatherapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WeatherSummaryExceptionHandler extends RuntimeException{
    private String message;
}
