package com.microrent.plataforma.controller;

import com.microrent.plataforma.model.Alojamiento;
import com.microrent.plataforma.service.AlojamientoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlojamientoController {

    private final AlojamientoService alojamientoService;

    public AlojamientoController(AlojamientoService alojamientoService) {
        this.alojamientoService = alojamientoService;
    }

    @GetMapping("/")
    public String listarAlojamientos(Model model) {
        model.addAttribute("alojamientos", alojamientoService.listarTodos());
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alojamiento", new Alojamiento());
        return "formulario";
    }

    @PostMapping("/")
    public String guardarAlojamiento(@ModelAttribute("alojamiento") Alojamiento alojamiento) {
        alojamientoService.guardar(alojamiento);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String verDetalles(@PathVariable String id, Model model) {
        Alojamiento alojamiento = alojamientoService.buscarPorId(id);
        if (alojamiento == null) return "redirect:/";

        model.addAttribute("alojamiento", alojamiento);
        return "detalles";
    }

    // ==========================================
    // 🔥 NUEVAS RUTAS: EDITAR Y BORRAR 🔥
    // ==========================================

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Alojamiento alojamiento = alojamientoService.buscarPorId(id);
        if (alojamiento == null) return "redirect:/";

        // Pasamos el alojamiento existente al formulario para que lo rellene
        model.addAttribute("alojamiento", alojamiento);
        return "formulario";
    }

    // Usamos POST para borrar por seguridad web
    @PostMapping("/borrar/{id}")
    public String borrarAlojamiento(@PathVariable String id) {
        alojamientoService.borrarPorId(id);
        return "redirect:/";
    }
}