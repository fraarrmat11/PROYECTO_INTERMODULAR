package com.example.nexspringboot.controller;
import com.example.nexspringboot.model.UsuarioLogro;
import com.example.nexspringboot.repository.UsuarioLogroRepository;
import com.example.nexspringboot.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario-logros")
public class UsuarioLogroController {

    private final UsuarioLogroRepository repo;
    private final UsuarioService usuarioService;

    public UsuarioLogroController(UsuarioLogroRepository repo, UsuarioService usuarioService) {
        this.repo = repo;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioLogro> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public UsuarioLogro getById(@PathVariable Integer id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public UsuarioLogro create(@RequestBody UsuarioLogro ul) {
        UsuarioLogro saved = repo.save(ul);
        int xp = saved.getLogro().getExperienciaXDesbloquear();
        usuarioService.agregarExperiencia(saved.getUsuario().getId(), xp);
        return saved;
    }

    @PutMapping("/{id}")
    public UsuarioLogro update(@PathVariable Integer id, @RequestBody UsuarioLogro ul) {
        ul.setId(id);
        return repo.save(ul);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repo.deleteById(id); }
}