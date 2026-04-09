package com.microrent.plataforma.controller;

import com.microrent.plataforma.model.Alojamiento;
import com.microrent.plataforma.repository.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlojamientoController {

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    @GetMapping("/")
    public String verInicio(Model model) {
        model.addAttribute("alojamientos", alojamientoRepository.findAll());
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        // Importante: Mandamos un objeto totalmente vacío
        model.addAttribute("alojamiento", new Alojamiento());
        return "formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        Alojamiento alojamiento = alojamientoRepository.findById(id).orElse(null);
        if (alojamiento != null) {
            model.addAttribute("alojamiento", alojamiento);
            return "formulario";
        }
        return "redirect:/";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Alojamiento alojamiento) {
        // Si el ID llega como "" (vacío), forzamos a que sea null
        // para que MongoDB genere uno nuevo obligatoriamente
        if (alojamiento.getId() != null && alojamiento.getId().isEmpty()) {
            alojamiento.setId(null);
        }
        alojamientoRepository.save(alojamiento);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        alojamientoRepository.deleteById(id);
        return "redirect:/";
    }
}