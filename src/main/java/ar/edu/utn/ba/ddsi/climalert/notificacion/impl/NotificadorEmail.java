package ar.edu.utn.ba.ddsi.climalert.notificacion.impl;

import ar.edu.utn.ba.ddsi.climalert.entity.ClimaActual;
import ar.edu.utn.ba.ddsi.climalert.notificacion.Notificador;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements Notificador {

    private final JavaMailSender mailSender;

    @Value("${alertas.email.destinatario}")
    private String destinatario;

    public NotificadorEmail(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void notificarAlerta(ClimaActual clima) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject("Alerta climática");
        mensaje.setText(
                "Se detectaron condiciones climáticas críticas:\n\n" +
                        "Ubicación: " + clima.getUbicacion() + "\n" +
                        "Temperatura: " + clima.getTemperatura() + "°C\n" +
                        "Humedad: " + clima.getHumedad() + "%\n" +
                        "Fecha de consulta: " + clima.getFechaConsulta()
        );

        mailSender.send(mensaje);
    }
}