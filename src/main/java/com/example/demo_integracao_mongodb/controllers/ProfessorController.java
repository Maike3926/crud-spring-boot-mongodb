
package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Professor;
import com.example.demo_integracao_mongodb.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public Professor gravar(@RequestBody Professor professor) {
        return this.professorRepository.save(professor);
    }

    @GetMapping
    public List<Professor> buscarTodos() {
        return this.professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Professor buscarPorId(@PathVariable String id) {
        return this.professorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Professor atualizar(
            @PathVariable String id,
            @RequestBody Professor professor) {

        Professor professorExistente =
                this.professorRepository.findById(id).orElse(null);

        if (professorExistente == null) {
            return null;
        }

        professorExistente.setNome(professor.getNome());
        professorExistente.setEmail(professor.getEmail());
        professorExistente.setIdade(professor.getIdade());

        return this.professorRepository.save(professorExistente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        this.professorRepository.deleteById(id);
    }
}
