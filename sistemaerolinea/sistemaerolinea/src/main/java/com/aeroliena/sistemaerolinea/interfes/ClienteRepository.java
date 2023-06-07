package com.aeroliena.sistemaerolinea.interfes;

import com.aeroliena.sistemaerolinea.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
