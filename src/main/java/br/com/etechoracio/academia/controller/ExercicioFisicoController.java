package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    private ExercicioFisicoService exercicioFisicoService;

    public ExercicioFisicoController(
            ExercicioFisicoService exercicioFisicoService) {

        this.exercicioFisicoService = exercicioFisicoService;
    }

    @GetMapping
    public List<ExercicioFisicoResponseDTO> buscarTodos() {
        return exercicioFisicoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDTO> buscarPorId(
            @PathVariable("id") Long id) {

        Optional<ExercicioFisicoResponseDTO> result =
                exercicioFisicoService.buscarPorId(id);

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ExercicioFisicoResponseDTO> criar(
            @RequestBody ExercicioFisicoRequestDTO exercicioFisicoRequestDTO) {

        ExercicioFisicoResponseDTO exercicioCriado =
                exercicioFisicoService.criar(exercicioFisicoRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(exercicioCriado);
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicioFisicoResponseDTO> aprovar(
            @PathVariable("id") Long id) {

        Optional<ExercicioFisicoResponseDTO> result =
                exercicioFisicoService.aprovar(id);

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}