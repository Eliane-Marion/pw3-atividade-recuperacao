package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;

@Service
public class ExercicioFisicoService {

    private ExercicioFisicoRepository exercicioFisicoRepository;
    private ExercicioFisicoMapper exercicioFisicoMapper;

    public ExercicioFisicoService(
            ExercicioFisicoRepository exercicioFisicoRepository,
            ExercicioFisicoMapper exercicioFisicoMapper) {

        this.exercicioFisicoRepository = exercicioFisicoRepository;
        this.exercicioFisicoMapper = exercicioFisicoMapper;
    }

    public List<ExercicioFisicoResponseDTO> buscarTodos() {
        return exercicioFisicoMapper.toResponseDTOList(
                exercicioFisicoRepository.findByAprovadoTrue()
        );
    }

    public Optional<ExercicioFisicoResponseDTO> buscarPorId(Long id) {
        return exercicioFisicoRepository.findByIdAndAprovadoTrue(id)
                .map(exercicioFisicoMapper::toResponseDTO);
    }

    public ExercicioFisicoResponseDTO criar(
            ExercicioFisicoRequestDTO exercicioFisicoRequestDTO) {

        ExercicioFisico exercicio =
                exercicioFisicoMapper.toEntity(exercicioFisicoRequestDTO);

        exercicio.setAprovado(false);

        ExercicioFisico exercicioSalvo =
                exercicioFisicoRepository.save(exercicio);

        return exercicioFisicoMapper.toResponseDTO(exercicioSalvo);
    }

    public Optional<ExercicioFisicoResponseDTO> aprovar(Long id) {
        return exercicioFisicoRepository.findById(id)
                .map(exercicio -> {
                    exercicio.setAprovado(true);

                    ExercicioFisico exercicioSalvo =
                            exercicioFisicoRepository.save(exercicio);

                    return exercicioFisicoMapper.toResponseDTO(exercicioSalvo);
                });
    }

}