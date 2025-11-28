package com.example.nexspringboot.controller;

import com.example.nexspringboot.model.Usuario;
import com.example.nexspringboot.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repo;

    public UsuarioController(UsuarioRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Usuario> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Integer id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) { return repo.save(usuario); }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return repo.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repo.deleteById(id); }
}