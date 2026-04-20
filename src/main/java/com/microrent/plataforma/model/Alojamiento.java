package com.microrent.plataforma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "alojamientos")
public class Alojamiento {

    @Id
    private String id;

    private String titulo;
    private String descripcion;
    private String ubicacion;
    private Double precioPorNoche;
    private boolean disponible;

    //  Campo específico para la portada de la tarjeta
    private String imagenPortada;

    // Lista para el carrusel de la página de detalles
    private List<String> imagenes = new ArrayList<>();
}