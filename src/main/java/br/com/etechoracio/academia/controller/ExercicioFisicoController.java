package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.response.ExercicioFisicoResponse;
import br.com.etechoracio.academia.exception.RecursoNaoEncontradoException;
import br.com.etechoracio.academia.request.ExercicioFisicoRequest;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    private final ExercicioFisicoService service;

    public ExercicioFisicoController(ExercicioFisicoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ExercicioFisicoResponse>> listar() {
        return ResponseEntity.ok(service.listarAprovados());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponse> buscarPorId(
            @PathVariable Long id) {

        try {
            return ResponseEntity.ok(service.buscarAprovadoPorId(id));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<ExercicioFisicoResponse> criar(
            @RequestBody ExercicioFisicoRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.criar(request));
    }
    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicioFisicoResponse> aprovar(
            @PathVariable Long id) {

        try {
            return ResponseEntity.ok(service.aprovar(id));
        } catch (RecursoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
}