package ar.edu.utn.ba.ddsi.climalert.entity;


import java.time.LocalDateTime;


public class ClimaActual {

    private Long id;

    private String ubicacion;
    private Double temperatura;
    private Double humedad;
    private LocalDateTime fechaConsulta;

    public ClimaActual() {}

    public ClimaActual(String ubicacion, Double temperatura, Double humedad) {
        this.ubicacion = ubicacion;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.fechaConsulta = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public Double getHumedad() {
        return humedad;
    }

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }
}