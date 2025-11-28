package com.example.nexspringboot.controller;
import com.example.nexspringboot.model.RegistroHabito;
import com.example.nexspringboot.repository.RegistroHabitoRepository;
import com.example.nexspringboot.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroHabitoController {

    private final RegistroHabitoRepository repo;
    private final UsuarioService usuarioService;

    public RegistroHabitoController(RegistroHabitoRepository repo, UsuarioService usuarioService) {
        this.repo = repo;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<RegistroHabito> getAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public RegistroHabito getById(@PathVariable Integer id) { return repo.findById(id).orElse(null); }

    @PostMapping
    public RegistroHabito create(@RequestBody RegistroHabito registro) {
        RegistroHabito saved = repo.save(registro);
        if (saved.getCompletado()) {
            int xp = saved.getHabito().getExperienciaXCompletar();
            usuarioService.agregarExperiencia(saved.getHabito().getUsuario().getId(), xp);
        }
        return saved;
    }

    @PutMapping("/{id}")
    public RegistroHabito update(@PathVariable Integer id, @RequestBody RegistroHabito registro) {
        registro.setId(id);
        return repo.save(registro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repo.deleteById(id); }
}
