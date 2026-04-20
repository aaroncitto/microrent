package com.microrent.plataforma.repository;

import com.microrent.plataforma.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    // Spring Boot es tan listo que buscará en la BBDD solo con escribir este nombre:
    Optional<Usuario> findByEmail(String email);
}