package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
@RequiredArgsConstructor
public class ExercicioFisicoController {

    private final ExercicioFisicoService service;

    @GetMapping
    public ResponseEntity<List<ExercicioFisicoResponseDTO>> buscarTodosAprovados() {
        return ResponseEntity.ok(service.buscarTodosAprovados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDTO> buscarAprovadoPorId(@PathVariable Long id) {
        return service.buscarAprovadoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExercicioFisicoResponseDTO> cadastrar(@RequestBody ExercicioFisicoRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(requestDTO));
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicioFisicoResponseDTO> aprovar(@PathVariable Long id) {
        return service.aprovar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
