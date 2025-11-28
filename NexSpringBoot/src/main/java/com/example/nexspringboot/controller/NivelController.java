package com.example.nexspringboot.controller;


import com.example.nexspringboot.model.Nivel;
import com.example.nexspringboot.repository.NivelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveles")
public class NivelController {

    private final NivelRepository repo;

    public NivelController(NivelRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Nivel> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Nivel getById(@PathVariable Integer id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public Nivel create(@RequestBody Nivel nivel) { return repo.save(nivel); }

    @PutMapping("/{id}")
    public Nivel update(@PathVariable Integer id, @RequestBody Nivel nivel) {
        nivel.setId(id);
        return repo.save(nivel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repo.deleteById(id); }
}
