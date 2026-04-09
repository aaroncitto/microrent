package com.microrent.plataforma.model;

import lombok.Data;
import org.springframework.data.annotation.Id; // <-- ESTE IMPORT ES CRÍTICO
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "alojamientos")
public class Alojamiento {

    @Id
    private String id;

    private String titulo;
    private String descripcion;
    private String ubicacion;
    private Double precioPorNoche;
    private boolean disponible;
    private String imagenUrl;
}