package com.microrent.plataforma.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // Lombok te ahorra escribir Getters y Setters
@Document(collection = "alojamientos") // Nombre de la "tabla" en MongoDB
public class Alojamiento {

    @Id
    private String id; // ID automático de MongoDB

    private String titulo;
    private String descripcion;
    private String ubicacion;
    private Double precioPorNoche;
    private boolean disponible;

}