package ar.edu.utn.ba.ddsi.climalert.service;

import ar.edu.utn.ba.ddsi.climalert.entity.ClimaActual;
import ar.edu.utn.ba.ddsi.climalert.notificacion.Notificador;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {

    @Value("${alertas.valores-criticos.temperatura}")
    private Double temperaturaCritica;

    @Value("${alertas.valores-criticos.humedad}")
    private Double humedadCritica;

    private final Notificador notificador;

    public AlertaService(Notificador notificador) {
        this.notificador = notificador;
    }

    public boolean hayAlerta(ClimaActual clima) {
        return clima.getTemperatura() > temperaturaCritica
                && clima.getHumedad() > humedadCritica;
    }

    public void procesar(ClimaActual clima) {
        if (hayAlerta(clima)) {
            System.out.println("ALERTA CLIMÁTICA");
            notificador.notificarAlerta(clima);
        } else {
            System.out.println("Sin alerta climática");
        }
    }
}