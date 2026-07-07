package ar.edu.utn.ba.ddsi.climalert.repository;

import ar.edu.utn.ba.ddsi.climalert.entity.ClimaActual;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class ClimaActualRepository {

    private final List<ClimaActual> climas = new ArrayList<>();

    public void save(ClimaActual clima) {
        climas.add(clima);
    }

    public List<ClimaActual> findAll() {
        return climas;
    }

    public Optional<ClimaActual> findTopByOrderByFechaConsultaDesc() {
        return climas.stream()
                .max(Comparator.comparing(ClimaActual::getFechaConsulta));
    }
}