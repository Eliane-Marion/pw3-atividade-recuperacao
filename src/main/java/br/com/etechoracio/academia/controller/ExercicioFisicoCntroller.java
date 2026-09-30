package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDto;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDto;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")

public class ExercicioFisicoCntroller {

    private final ExercicioFisicoService service;

    public ExercicioFisicoCntroller(ExercicioFisicoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ExercicioFisicoResponseDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDto> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExercicioFisicoResponseDto> cadastrar(
            @RequestBody ExercicioFisicoRequestDto dto
            ){
        ExercicioFisicoResponseDto exercicio = service.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(exercicio);
    }
    
    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicioFisicoResponseDto> aprovar(@PathVariable Long id){
        return service.aprovar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
