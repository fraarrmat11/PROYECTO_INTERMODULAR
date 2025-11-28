package com.example.nexspringboot.controller;
import com.example.nexspringboot.model.Diario;
import com.example.nexspringboot.repository.DiarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diarios")
public class DiarioController {

    private final DiarioRepository repo;

    public DiarioController(DiarioRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Diario> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Diario getById(@PathVariable Integer id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public Diario create(@RequestBody Diario diario) { return repo.save(diario); }

    @PutMapping("/{id}")
    public Diario update(@PathVariable Integer id, @RequestBody Diario diario) {
        diario.setId(id);
        return repo.save(diario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repo.deleteById(id); }
}
