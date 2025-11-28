package com.example.nexspringboot.repository;

import com.example.nexspringboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}