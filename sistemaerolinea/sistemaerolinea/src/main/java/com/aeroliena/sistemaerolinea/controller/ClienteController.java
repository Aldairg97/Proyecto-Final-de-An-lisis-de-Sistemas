package com.aeroliena.sistemaerolinea.controller;

import com.aeroliena.sistemaerolinea.interfes.ClienteRepository;
import com.aeroliena.sistemaerolinea.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @GetMapping("/")
    public List<Cliente> obtenerTodosClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @PostMapping("/")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable int id, @RequestBody Cliente clienteActualizado) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombreCliente(clienteActualizado.getNombreCliente());
            cliente.setTelefono(clienteActualizado.getTelefono());
            // Actualizar otros campos si es necesario

            return clienteRepository.save(cliente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable int id) {
        clienteRepository.deleteById(id);
    }
}
