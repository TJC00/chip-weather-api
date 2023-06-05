package com.chipthynk.chipweatherapi.dto;

import lombok.Data;

@Data
public class HourlyUnits {
    private String apparent_temperature;
    private String precipitation;
    private String precipitation_probability;
    private String relativehumidity_2m;
    private String temperature_2m;
    private String time;
    private String uv_index;
    private String windgusts_10m;
}
