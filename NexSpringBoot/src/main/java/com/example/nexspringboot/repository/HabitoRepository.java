package com.example.nexspringboot.repository;
import com.example.nexspringboot.model.Habito;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitoRepository extends JpaRepository<Habito, Integer> {}