package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioFisicoService {

    private final ExercicioFisicoRepository repository;
    private final ExercicioFisicoMapper mapper;

    public ExercicioFisicoService(ExercicioFisicoRepository repository, ExercicioFisicoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ExercicioFisicoResponseDTO> listarAprovados() {
        return repository.findByAprovadoTrue()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public ExercicioFisicoResponseDTO buscarPorId(Long id) {
        return repository.findByIdAndAprovadoTrue(id)
                .map(mapper::toResponseDTO)
                .orElse(null);
    }

    public ExercicioFisicoResponseDTO criar(ExercicioFisicoRequestDTO requestDTO) {
        ExercicioFisico exercicio = mapper.toEntity(requestDTO);
        exercicio.setAprovado(false);
        ExercicioFisico salvo = repository.save(exercicio);
        return mapper.toResponseDTO(salvo);
    }

    public ExercicioFisicoResponseDTO aprovar(Long id) {
        return repository.findById(id)
                .map(exercicio -> {
                    exercicio.setAprovado(true);
                    ExercicioFisico salvo = repository.save(exercicio);
                    return mapper.toResponseDTO(salvo);
                })
                .orElse(null);
    }
}
