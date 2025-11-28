package com.example.nexspringboot.controller;
import com.example.nexspringboot.model.Logro;
import com.example.nexspringboot.repository.LogroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logros")
public class LogroController {

    private final LogroRepository repo;

    public LogroController(LogroRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Logro> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Logro getById(@PathVariable Integer id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public Logro create(@RequestBody Logro logro) { return repo.save(logro); }

    @PutMapping("/{id}")
    public Logro update(@PathVariable Integer id, @RequestBody Logro logro) {
        logro.setId(id);
        return repo.save(logro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repo.deleteById(id); }
}
