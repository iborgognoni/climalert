package ar.edu.utn.ba.ddsi.climalert.scheduler;

import ar.edu.utn.ba.ddsi.climalert.entity.ClimaActual;
import ar.edu.utn.ba.ddsi.climalert.repository.ClimaActualRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {

    private final ClimaActualRepository climaActualRepository;

    public ClimaScheduler(ClimaActualRepository climaActualRepository) {
        this.climaActualRepository = climaActualRepository;
    }

    @Scheduled(fixedRate = 5000) // 300000 cada 5 minutos
    public void consultarClima() {
        ClimaActual clima = new ClimaActual("CABA", 36.0, 70.0);

        climaActualRepository.save(clima);

        System.out.println("Clima guardado: " + clima.getTemperatura() + "°C - " + clima.getHumedad() + "%");
    }
}