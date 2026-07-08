package ar.edu.utn.ba.ddsi.climalert.domain.adapter.impl;

import ar.edu.utn.ba.ddsi.climalert.domain.adapter.ApiClima;
import ar.edu.utn.ba.ddsi.climalert.dto.WeatherApiResponse;
import ar.edu.utn.ba.ddsi.climalert.entity.ClimaActual;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherApiAdapter implements ApiClima {

    private final RestClient restClient;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.location}")
    private String location;

    public WeatherApiAdapter(@Value("${weather.api.url}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public ClimaActual obtenerClimaActual() {
        WeatherApiResponse response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", apiKey)
                        .queryParam("q", location)
                        .build())
                .retrieve()
                .body(WeatherApiResponse.class);

        assert response != null;


        System.out.println(response.getCurrent().getTemp_c());
        System.out.println(response.getCurrent().getHumidity());

        return new ClimaActual(
                location,
                response.getCurrent().getTemp_c(),
                response.getCurrent().getHumidity()
        );
    }
}