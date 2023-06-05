package com.chipthynk.chipweatherapi.dto;

import lombok.Data;

@Data
public class CurrentWeather {
    private String temperature;
    private String windspeed;
    private String winddirection;
    private String weathercode;
    private String time;
}
