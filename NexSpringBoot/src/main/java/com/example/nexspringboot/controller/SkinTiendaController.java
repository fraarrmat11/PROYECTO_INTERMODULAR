package com.example.nexspringboot.controller;
import com.example.nexspringboot.model.SkinTienda;
import com.example.nexspringboot.repository.SkinTiendaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skins")
public class SkinTiendaController {

    private final SkinTiendaRepository repo;

    public SkinTiendaController(SkinTiendaRepository repo) { this.repo = repo; }

    @GetMapping
    public List<SkinTienda> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public SkinTienda getById(@PathVariable Integer id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public SkinTienda create(@RequestBody SkinTienda skin) { return repo.save(skin); }

    @PutMapping("/{id}")
    public SkinTienda update(@PathVariable Integer id, @RequestBody SkinTienda skin) {
        skin.setId(id);
        return repo.save(skin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repo.deleteById(id); }
}
