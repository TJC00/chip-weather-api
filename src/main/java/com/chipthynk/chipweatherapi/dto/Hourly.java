package com.chipthynk.chipweatherapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class Hourly {
    private List<Integer> temperature_2m;
    private List<Integer> relativehumidity_2m;
    private List<Integer> windgusts_10m;
    private List<Integer> precipitation_probability;
    private List<Integer> uv_index;
}
