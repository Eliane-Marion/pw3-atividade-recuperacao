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
        return mapper.toResponseDTOList(repository.findByAprovadoTrue());
    }

    public Optional<ExercicioFisicoResponseDTO> buscarAprovadoPorId(Long id) {
        return repository.findByIdAndAprovadoTrue(id).map(mapper::toResponseDTO);
    }

    public ExercicioFisicoResponseDTO cadastrar(ExercicioFisicoRequestDTO dto) {
        ExercicioFisico exercicio = mapper.toEntity(dto);
        exercicio.setAprovado(false);
        return mapper.toResponseDTO(repository.save(exercicio));
    }

    public Optional<ExercicioFisicoResponseDTO> aprovar(Long id) {
        return repository.findById(id).map(exercicio -> {
            exercicio.setAprovado(true);
            return mapper.toResponseDTO(repository.save(exercicio));
        });
    }

}
