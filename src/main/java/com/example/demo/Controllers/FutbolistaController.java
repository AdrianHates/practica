package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositories.FutbolistaRepository;
import com.example.demo.Entities.Futbolista;

@RestController
@RequestMapping("/futbolista")

public class FutbolistaController {

  @Autowired
  private FutbolistaRepository futbolistaRepository;

  @GetMapping
  public List<Futbolista> getAllFutbolista() {
    return futbolistaRepository.findAll();
  }

  @GetMapping("/{id}")
  public Futbolista getFutbolistaById(@PathVariable Long id) {
    return futbolistaRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("No se encontró el producto con el Id: " + id));
  }

  @PostMapping
  public Futbolista createFutbolista(@RequestBody Futbolista futbolista) {
    return futbolistaRepository.save(futbolista);
  }
}
