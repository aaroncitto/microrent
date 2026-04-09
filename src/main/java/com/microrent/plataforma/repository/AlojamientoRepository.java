package com.microrent.plataforma.repository;

import com.microrent.plataforma.model.Alojamiento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlojamientoRepository extends MongoRepository<Alojamiento, String> {
    // Aquí no hace falta escribir nada más
}