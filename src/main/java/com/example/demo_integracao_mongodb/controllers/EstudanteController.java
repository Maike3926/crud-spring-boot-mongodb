package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Estudante;
import com.example.demo_integracao_mongodb.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("api/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteRepository estudanteRepository;

    @PostMapping
    public void gravar(@RequestBody Estudante estudante) {
        this.estudanteRepository.save(estudante);
    }
    @GetMapping
    public List<Estudante> buscarTodos() {
        return this.estudanteRepository.findAll();
    }
    @GetMapping("/{id}")
    public Estudante buscarPorId(@PathVariable String id) {
        return this.estudanteRepository.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public Estudante atualizar(
            @PathVariable String id,
            @RequestBody Estudante estudante) {

        Estudante estudanteExistente =
                this.estudanteRepository.findById(id).orElse(null);

        if (estudanteExistente == null) {
            return null;
        }

        estudanteExistente.setNome(estudante.getNome());
        estudanteExistente.setEmail(estudante.getEmail());
        estudanteExistente.setIdade(estudante.getIdade());

        return this.estudanteRepository.save(estudanteExistente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        this.estudanteRepository.deleteById(id);
    }

}
