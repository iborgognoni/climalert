package ar.edu.utn.ba.ddsi.climalert.scheduler;

import ar.edu.utn.ba.ddsi.climalert.domain.adapter.ApiClima;
import ar.edu.utn.ba.ddsi.climalert.entity.ClimaActual;
import ar.edu.utn.ba.ddsi.climalert.repository.ClimaActualRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {

    private final ApiClima apiClima;
    private final ClimaActualRepository repository;

    public ClimaScheduler(ApiClima apiClima, ClimaActualRepository repository) {
        this.apiClima = apiClima;
        this.repository = repository;
    }

    @Scheduled(fixedRateString = "${scheduler.consulta-clima.intervalo}")
    public void consultarClima() {
        ClimaActual clima = apiClima.obtenerClimaActual();
        repository.save(clima);
    }
}