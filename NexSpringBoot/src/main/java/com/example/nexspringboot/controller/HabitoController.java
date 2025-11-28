package com.example.nexspringboot.controller;
import com.example.nexspringboot.model.Habito;
import com.example.nexspringboot.repository.HabitoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitos")
public class HabitoController {

    private final HabitoRepository repo;

    public HabitoController(HabitoRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Habito> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Habito getById(@PathVariable Integer id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public Habito create(@RequestBody Habito habito) { return repo.save(habito); }

    @PutMapping("/{id}")
    public Habito update(@PathVariable Integer id, @RequestBody Habito habito) {
        habito.setId(id);
        return repo.save(habito);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repo.deleteById(id); }
}