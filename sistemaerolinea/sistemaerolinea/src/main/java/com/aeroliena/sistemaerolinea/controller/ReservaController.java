package com.aeroliena.sistemaerolinea.controller;

import com.aeroliena.sistemaerolinea.interfes.ReservaRepository;
import com.aeroliena.sistemaerolinea.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @GetMapping("/{id}")
    public Reserva obtenerReservaPorId(@PathVariable("id") int id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Reserva actualizarReserva(@PathVariable("id") int id, @RequestBody Reserva reserva) {
        reserva.setIdReserva(id);
        return reservaRepository.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable("id") int id) {
        reservaRepository.deleteById(id);
    }
}
