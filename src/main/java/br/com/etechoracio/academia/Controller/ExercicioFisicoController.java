package br.com.etechoracio.academia.Controller;

import br.com.etechoracio.academia.DTO.ExercicioFIsicoRequestDTO;
import br.com.etechoracio.academia.DTO.ExercicoFisicoResponseDTO;
import br.com.etechoracio.academia.Service.ExercicioFisicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    private final ExercicioFisicoService service;

    public ExercicioFisicoController(
            ExercicioFisicoService service) {

        this.service = service;
    }

    @GetMapping
    public List<ExercicoFisicoResponseDTO> listar() {
        return service.listarAprovados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicoFisicoResponseDTO> buscarPorId(@PathVariable Long id) {
        var exercicio = service.buscarPorId(id);
        if(exercicio == null)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(exercicio);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExercicoFisicoResponseDTO criar(
            @RequestBody ExercicioFIsicoRequestDTO requestDTO) {
        return service.criar(requestDTO);
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicoFisicoResponseDTO> aprovar(
            @PathVariable Long id) {

        ExercicoFisicoResponseDTO exercicio =
                service.aprovar(id);

        return ResponseEntity.ok(exercicio);
    }
}