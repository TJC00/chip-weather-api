package com.chipthynk.chipweatherapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WeatherDetailsFailedLoading extends RuntimeException {
    String message;
}
