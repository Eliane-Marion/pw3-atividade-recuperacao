package br.com.etechoracio.academia.controller;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    private final ExercicioFisicoService service;

    public ExercicioFisicoController(
            ExercicioFisicoService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ExercicioFisicoResponse>> listar() {

        return ResponseEntity.ok(
                service.listarAprovados()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponse> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<ExercicioFisicoResponse> cadastrar(
            @RequestBody ExercicioFisicoRequest request) {

        ExercicioFisicoResponse response =
                service.cadastrar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PatchMapping("/{id}/aprovar")
    public ResponseEntity<ExercicioFisicoResponse> aprovar(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.aprovar(id)
        );
    }
}