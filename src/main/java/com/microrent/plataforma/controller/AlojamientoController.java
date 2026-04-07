package com.microrent.plataforma.controller;

import com.microrent.plataforma.model.Alojamiento;
import com.microrent.plataforma.repository.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Indica que esta clase manejará rutas URL y devolverá datos (JSON)
public class AlojamientoController {

    @Autowired // "Inyecta" el repositorio automáticamente (Magia de Spring)
    private AlojamientoRepository alojamientoRepository;

    @GetMapping("/crear-test") // Al entrar en http://localhost:8080/crear-test pasará esto:
    public String crearPrueba() {
        Alojamiento test = new Alojamiento();
        test.setTitulo("Apartamento en la Playa");
        test.setDescripcion("Hermosas vistas al mar y muy luminoso");
        test.setUbicacion("Valencia, España");
        test.setPrecioPorNoche(85.0);
        test.setDisponible(true);

        alojamientoRepository.save(test); // ¡Aquí se guarda en MongoDB Atlas!

        return "¡Alojamiento guardado con éxito! Revisa tu MongoDB Compass.";
    }

    @GetMapping("/listar") // Para ver todos los que hay guardados
    public List<Alojamiento> listarTodos() {
        return alojamientoRepository.findAll();
    }
}