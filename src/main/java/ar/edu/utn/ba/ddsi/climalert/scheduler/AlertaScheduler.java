package ar.edu.utn.ba.ddsi.climalert.scheduler;

import ar.edu.utn.ba.ddsi.climalert.repository.ClimaActualRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertaScheduler {

    private final ClimaActualRepository climaActualRepository;

    public AlertaScheduler(ClimaActualRepository climaActualRepository) {
        this.climaActualRepository = climaActualRepository;
    }

    @Scheduled(fixedRate = 10000) // 60000 cada 1 minuto
    public void analizarAlertas() {
        climaActualRepository.findTopByOrderByFechaConsultaDesc()
                .ifPresent(clima -> {
                    if (clima.getTemperatura() > 35 && clima.getHumedad() > 60) {
                        System.out.println("ALERTA CLIMÁTICA: temperatura alta y humedad elevada");
                    }
                });
    }
}