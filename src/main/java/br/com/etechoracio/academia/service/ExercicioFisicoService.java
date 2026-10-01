package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExercicioFisicoService {

    private final ExercicioFisicoRepository repository;
    private final ExercicioFisicoMapper mapper;

    public List<ExercicioFisicoResponseDTO> listarAprovados() {
        return mapper.toResponseList(repository.findByAprovadoTrue());
    }

    public Optional<ExercicioFisicoResponseDTO> buscarAprovadoPorId(Long id) {
        return repository.findByIdAndAprovadoTrue(id).map(mapper::toResponse);
    }

    public ExercicioFisicoResponseDTO criar(ExercicioFisicoRequestDTO dto) {
        ExercicioFisico entity = mapper.toEntity(dto);
        entity.setAprovado(false);
        return mapper.toResponse(repository.save(entity));
    }

    public ExercicioFisicoResponseDTO aprovar(Long id) {
        ExercicioFisico entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercício não encontrado"));
        entity.setAprovado(true);
        return mapper.toResponse(repository.save(entity));
    }
}