package ar.edu.utn.ba.ddsi.climalert.scheduler;

import ar.edu.utn.ba.ddsi.climalert.repository.ClimaActualRepository;
import ar.edu.utn.ba.ddsi.climalert.service.AlertaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertaScheduler {

    private final ClimaActualRepository repository;
    private final AlertaService alertaService;

    public AlertaScheduler(ClimaActualRepository repository,
                           AlertaService alertaService) {
        this.repository = repository;
        this.alertaService = alertaService;
    }

    @Scheduled(fixedRateString = "${scheduler.analisis-alertas.intervalo}")
    public void analizarUltimoClima() {
        repository.findTopByOrderByFechaConsultaDesc()
                .ifPresent(alertaService::procesar);
    }
}
