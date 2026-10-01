package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
@RequiredArgsConstructor
public class ExercicioFisicoController {

    private final ExercicioFisicoService service;

    @GetMapping
    public List<ExercicioFisicoResponseDTO> listar() {
        return service.listarAprovados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarAprovadoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExercicioFisicoResponseDTO> criar(@RequestBody ExercicioFisicoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @PatchMapping("/{id}/aprovar")
    public ExercicioFisicoResponseDTO aprovar(@PathVariable Long id) {
        return service.aprovar(id);
    }
}