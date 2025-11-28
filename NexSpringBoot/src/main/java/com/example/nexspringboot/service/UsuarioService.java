package com.example.nexspringboot.service;

import com.example.nexspringboot.model.Usuario;
import com.example.nexspringboot.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public void agregarExperiencia(Integer usuarioId, int experiencia) {
        usuarioRepository.findById(usuarioId).ifPresent(usuario -> {
            usuario.setExperienciaActual(usuario.getExperienciaActual() + experiencia);
            usuarioRepository.save(usuario);
        });
    }
}
