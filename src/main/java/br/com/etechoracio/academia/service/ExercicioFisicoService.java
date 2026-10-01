package br.com.etechoracio.academia.service;


@Service
public class ExercicioFisicoService {

    private final ExercicioFisicoRepository repository;
    private final ExercicioFisicoMapper mapper;

    public ExercicioFisicoService(
            ExercicioFisicoRepository repository,
            ExercicioFisicoMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ExercicioFisicoResponse> listarAprovados() {

        return repository.findAllByAprovadoTrue()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ExercicioFisicoResponse buscarPorId(Long id) {

        ExercicioFisico exercicio = repository.findByIdAndAprovadoTrue(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Exercício físico não encontrado"
                ));

        return mapper.toResponse(exercicio);
    }

    public ExercicioFisicoResponse cadastrar(
            ExercicioFisicoRequest request) {

        ExercicioFisico exercicio = mapper.toEntity(request);

        exercicio.setAprovado(false);

        ExercicioFisico exercicioSalvo =
                repository.save(exercicio);

        return mapper.toResponse(exercicioSalvo);
    }

    public ExercicioFisicoResponse aprovar(Long id) {

        ExercicioFisico exercicio = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Exercício físico não encontrado"
                ));

        exercicio.setAprovado(true);

        ExercicioFisico exercicioSalvo =
                repository.save(exercicio);

        return mapper.toResponse(exercicioSalvo);
    }
}
