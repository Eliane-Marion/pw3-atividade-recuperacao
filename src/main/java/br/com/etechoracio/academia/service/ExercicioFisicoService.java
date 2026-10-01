package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExercicioFisicoService {

    private final ExercicioFisicoRepository repository;
    private final ExercicioFisicoMapper mapper;

    public List<ExercicioFisicoResponseDTO> buscarTodosAprovados() {
        List<ExercicioFisico> exerciciosFisicos = repository.findByAprovadoTrue();
        return mapper.toResponseDTOList(exerciciosFisicos);
    }

    public Optional<ExercicioFisicoResponseDTO> buscarAprovadoPorId(Long id) {
        Optional<ExercicioFisico> exercicioFisico = repository.findByIdAndAprovadoTrue(id);
        return exercicioFisico.map(mapper::toResponseDTO);
    }

    public ExercicioFisicoResponseDTO cadastrar(ExercicioFisicoRequestDTO requestDTO) {
        ExercicioFisico exercicioFisico = mapper.toEntity(requestDTO);
        exercicioFisico.setAprovado(false);
        ExercicioFisico exercicioFisicoSalvo = repository.save(exercicioFisico);
        return mapper.toResponseDTO(exercicioFisicoSalvo);
    }

    public Optional<ExercicioFisicoResponseDTO> aprovar(Long id) {
        Optional<ExercicioFisico> exercicioFisico = repository.findById(id);
        return exercicioFisico.map(exercicio -> {
            exercicio.setAprovado(true);
            ExercicioFisico exercicioFisicoAprovado = repository.save(exercicio);
            return mapper.toResponseDTO(exercicioFisicoAprovado);
        });
    }

}
