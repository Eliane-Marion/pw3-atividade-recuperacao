package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.response.ExercicioFisicoResponse;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.exception.RecursoNaoEncontradoException;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import br.com.etechoracio.academia.request.ExercicioFisicoRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.findByAprovadoTrue()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
    public ExercicioFisicoResponse buscarAprovadoPorId(Long id) {
        ExercicioFisico exercicio = repository.findByIdAndAprovadoTrue(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Exercício físico aprovado não encontrado para o id: " + id
                ));

        return mapper.toResponse(exercicio);
    }
    public ExercicioFisicoResponse criar(ExercicioFisicoRequest request) {
        ExercicioFisico exercicio = mapper.toEntity(request);

        exercicio.setAprovado(false);

        ExercicioFisico salvo = repository.save(exercicio);

        return mapper.toResponse(salvo);
    }
    public ExercicioFisicoResponse aprovar(Long id) {
        ExercicioFisico exercicio = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Exercício físico não encontrado para o id: " + id
                ));

        exercicio.setAprovado(true);

        ExercicioFisico salvo = repository.save(exercicio);

        return mapper.toResponse(salvo);
    }
}