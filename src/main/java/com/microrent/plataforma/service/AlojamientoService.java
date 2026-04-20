package com.microrent.plataforma.service;

import com.microrent.plataforma.model.Alojamiento;
import com.microrent.plataforma.repository.AlojamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoService {

    private final AlojamientoRepository repository;

    public AlojamientoService(AlojamientoRepository repository) {
        this.repository = repository;
    }

    public List<Alojamiento> listarTodos() {
        return repository.findAll();
    }

    public Alojamiento buscarPorId(String id) {
        Optional<Alojamiento> alojamiento = repository.findById(id);
        return alojamiento.orElse(null);
    }

    public Alojamiento guardar(Alojamiento alojamiento) {
        // Truco de limpieza: Quitamos los espacios en blanco de las URLs si el usuario las pega mal
        if (alojamiento.getImagenes() != null) {
            alojamiento.setImagenes(alojamiento.getImagenes().stream()
                    .map(String::trim)
                    .filter(url -> !url.isEmpty())
                    .toList());
        }
        return repository.save(alojamiento);
    }

    public double calcularPrecioTotal(String id, int noches) {
        Alojamiento alojamiento = buscarPorId(id);
        if (alojamiento != null && alojamiento.getPrecioPorNoche() != null) {
            return alojamiento.getPrecioPorNoche() * noches;
        }
        return 0.0;
    }
    // Añade este método en AlojamientoService.java
    public void borrarPorId(String id) {
        repository.deleteById(id);
    }
}