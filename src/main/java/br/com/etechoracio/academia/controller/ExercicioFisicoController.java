package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDto;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDto;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    @Autowired
    private ExercicioFisicoService exercicioFisicoService;

    @GetMapping
    public ResponseEntity<List<ExercicioFisicoResponseDto>> findByAprovado() {
        var result = exercicioFisicoService.findByAprovado();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDto> findById(@PathVariable Long id) {
        var result = exercicioFisicoService.findById(id);

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ExercicioFisicoResponseDto> save(
            @RequestBody ExercicioFisicoRequestDto dto) {

        var result = exercicioFisicoService.save(dto);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicioFisicoResponseDto> aprovar(@PathVariable Long id) {
        var result = exercicioFisicoService.aprovar(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.notFound().build();
    }

}