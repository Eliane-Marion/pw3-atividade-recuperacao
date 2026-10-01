package controller;

import dto.ExercicioFisicoResponseDTO;
import service.ExercicioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    @Autowired
    private ExercicioFisicoService service;

    // Etapa 1
    @GetMapping
    public ResponseEntity<List<ExercicioFisicoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarAprovados());
    }

    // Etapa 2
    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorIdAprovado(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Retorna 404 caso não ache
    }
}