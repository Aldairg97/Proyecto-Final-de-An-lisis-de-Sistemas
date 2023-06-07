package com.aeroliena.sistemaerolinea.interfes;

import com.aeroliena.sistemaerolinea.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmailAndNombre(String email, String nombre);
}
