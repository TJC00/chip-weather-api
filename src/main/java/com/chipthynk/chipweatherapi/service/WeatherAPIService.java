package com.chipthynk.chipweatherapi.service;

import com.chipthynk.chipweatherapi.dto.ChatGPTRequest;
import com.chipthynk.chipweatherapi.dto.ChatGptResponse;
import com.chipthynk.chipweatherapi.exceptions.WeatherDetailsFailedLoading;
import com.chipthynk.chipweatherapi.exceptions.WeatherSummaryExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherAPIService {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    public String  weatherDetailsSummary(String prompt){
        String userPrompt = "Hi there, can i get a summary of today's weather, use the following information to get the weather ";
        String systemPrompt = "Pretend you're a weather news presenter presenting LIVE on television. be energetic and full of charisma. Introduce yourself as TJ. Chidanika and say you are LIVE from the ChipThynk Headquarters. State the city you are providing a summary for. Then give a summary of today's weather only. Make it easy for the viewer to understand and know what to do to prepare for those weather conditions such as wear SPF if the UV is high etc. use the uv_index data provided to provide UV advice. Provide a joke regarding the weather. Assume the data came from your team at the news office and not the user.";
        String refinedPrompt = userPrompt + prompt;
        try{
            ChatGPTRequest request=new ChatGPTRequest(model, systemPrompt, refinedPrompt);
            ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);
            return chatGptResponse.getChoices().get(0).getMessage().getContent();
        }catch (Exception e){
            throw new WeatherSummaryExceptionHandler("Failed to load weather details summary");
        }

    }

    public String getWeatherDetails(String longitude, String latitude){
        RestTemplate restTemplate = new RestTemplate();
        String uri = String.format("https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&hourly=temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,precipitation,windgusts_10m,uv_index&daily=weathercode,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,sunrise,sunset,uv_index_max,uv_index_clear_sky_max&current_weather=true&timezone=GMT", latitude, longitude);

        try{
            ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
            return response.getBody();
        }catch (Exception e){
            throw new WeatherDetailsFailedLoading("Weather Details Failed To Load Please Check If You Have Internet Connection.");
        }
    }

}
