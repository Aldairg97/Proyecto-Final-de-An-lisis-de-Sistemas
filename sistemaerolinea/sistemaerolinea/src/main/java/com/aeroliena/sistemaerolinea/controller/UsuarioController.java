package com.aeroliena.sistemaerolinea.controller;

import com.aeroliena.sistemaerolinea.interfes.UsuarioRepository;
import com.aeroliena.sistemaerolinea.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable("id") int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @GetMapping("/autenticar")
    public int autenticarUsuario(@RequestParam("email") String email, @RequestParam("nombre") String nombre) {
        Usuario usuario = usuarioRepository.findByEmailAndNombre(email, nombre);
        if (usuario != null) {
            return 1; // Usuario existe
        } else {
            return 0; // Usuario no existe
        }
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable("id") int id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") int id) {
        usuarioRepository.deleteById(id);
    }
}

