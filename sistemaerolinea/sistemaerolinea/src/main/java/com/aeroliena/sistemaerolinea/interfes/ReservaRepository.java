package com.aeroliena.sistemaerolinea.interfes;

import com.aeroliena.sistemaerolinea.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
