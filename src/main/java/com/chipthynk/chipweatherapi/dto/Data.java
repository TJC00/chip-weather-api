package com.chipthynk.chipweatherapi.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private CurrentWeather current_weather;
    private Hourly hourly;
    private String timezone;
    private String timezone_abbreviation;
    private HourlyUnits hourly_units;
    private String city;
}
