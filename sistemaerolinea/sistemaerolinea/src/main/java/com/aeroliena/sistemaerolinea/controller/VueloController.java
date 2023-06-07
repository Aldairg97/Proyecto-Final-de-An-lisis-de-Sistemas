package com.aeroliena.sistemaerolinea.controller;

import com.aeroliena.sistemaerolinea.interfes.VueloRepository;
import com.aeroliena.sistemaerolinea.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {
    @Autowired
    private VueloRepository vueloRepository;

    @GetMapping
    public List<Vuelo> obtenerVuelos() {
        return vueloRepository.findAll();
    }

    @PostMapping
    public Vuelo crearVuelo(@RequestBody Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    @GetMapping("/{id}")
    public Vuelo obtenerVueloPorId(@PathVariable("id") int id) {
        return vueloRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Vuelo actualizarVuelo(@PathVariable("id") int id, @RequestBody Vuelo vuelo) {
        vuelo.setIdVuelo(id);
        return vueloRepository.save(vuelo);
    }

    @DeleteMapping("/{id}")
    public void eliminarVuelo(@PathVariable("id") int id) {
        vueloRepository.deleteById(id);
    }
}
