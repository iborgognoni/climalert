package ar.edu.utn.ba.ddsi.climalert.notificacion;

import ar.edu.utn.ba.ddsi.climalert.entity.ClimaActual;

public interface Notificador {
    void notificarAlerta(ClimaActual clima);
}