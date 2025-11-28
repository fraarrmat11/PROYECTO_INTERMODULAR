package com.example.nexspringboot.repository;
import com.example.nexspringboot.model.Diario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiarioRepository extends JpaRepository<Diario, Integer> {}