package com.aeroliena.sistemaerolinea.interfes;

import com.aeroliena.sistemaerolinea.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
}
