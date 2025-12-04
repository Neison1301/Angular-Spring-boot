package com.example.cliente_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cliente_backend.model.Cliente;
import com.example.cliente_backend.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")

public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping
  public List<Cliente> listar() {
    return clienteRepository.findAll();
  }

  @PostMapping
  public Cliente guardar(@RequestBody Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @DeleteMapping("/{id}")
  public void eliminar(@PathVariable Long id) {
    clienteRepository.deleteById(id);
  }
}
