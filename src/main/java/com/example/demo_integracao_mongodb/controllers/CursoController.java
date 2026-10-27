
package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Curso;
import com.example.demo_integracao_mongodb.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public void gravar(@RequestBody Curso curso) {
        this.cursoRepository.save(curso);
    }

    @GetMapping
    public List<Curso> buscarTodos() {
        return this.cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable String id) {
        return this.cursoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Curso atualizar(
            @PathVariable String id,
            @RequestBody Curso curso) {

        Curso cursoExistente =
                this.cursoRepository.findById(id).orElse(null);

        if (cursoExistente == null) {
            return null;
        }

        cursoExistente.setDescricao(curso.getDescricao());

        return this.cursoRepository.save(cursoExistente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        this.cursoRepository.deleteById(id);
    }
}
