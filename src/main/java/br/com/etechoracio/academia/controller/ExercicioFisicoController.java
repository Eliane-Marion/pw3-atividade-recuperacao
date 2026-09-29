package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
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
    public ResponseEntity<List<ExercicioFisicoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarAprovados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDTO> buscarPorId(@PathVariable Long id) {
        ExercicioFisicoResponseDTO dto = service.buscarPorId(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ExercicioFisicoResponseDTO> criar(@RequestBody ExercicioFisicoRequestDTO requestDTO) {
        ExercicioFisicoResponseDTO dto = service.criar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicioFisicoResponseDTO> aprovar(@PathVariable Long id) {
        ExercicioFisicoResponseDTO dto = service.aprovar(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
}
