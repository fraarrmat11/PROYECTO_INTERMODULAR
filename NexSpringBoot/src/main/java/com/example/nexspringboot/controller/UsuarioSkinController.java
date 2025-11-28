package com.example.nexspringboot.controller;
import com.example.nexspringboot.model.UsuarioSkin;
import com.example.nexspringboot.repository.UsuarioSkinRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario-skins")
public class UsuarioSkinController {

    private final UsuarioSkinRepository repo;

    public UsuarioSkinController(UsuarioSkinRepository repo) { this.repo = repo; }

    @GetMapping
    public List<UsuarioSkin> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public UsuarioSkin getById(@PathVariable Integer id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public UsuarioSkin create(@RequestBody UsuarioSkin us) { return repo.save(us); }

    @PutMapping("/{id}")
    public UsuarioSkin update(@PathVariable Integer id, @RequestBody UsuarioSkin us) {
        us.setId(id);
        return repo.save(us);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repo.deleteById(id); }
}
