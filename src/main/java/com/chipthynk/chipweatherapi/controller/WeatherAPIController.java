package com.chipthynk.chipweatherapi.controller;

import com.chipthynk.chipweatherapi.dto.ContentData;
import com.chipthynk.chipweatherapi.dto.Data;
import com.chipthynk.chipweatherapi.service.WeatherAPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/weather-app")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "*"})
public class WeatherAPIController {

    private final WeatherAPIService apiService;
    @GetMapping("/{longitude}/{latitude}")
    public ResponseEntity<String> getWeatherDetails(@PathVariable String latitude, @PathVariable String longitude){
        String results = apiService.getWeatherDetails(latitude, longitude);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ContentData> getWeatherSummaryDetails(@RequestBody Data prompt){
        ContentData result = apiService.weatherDetailsSummary(prompt.toString());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
