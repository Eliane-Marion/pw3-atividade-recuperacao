package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercicioFisicoService {

    private final ExercicioFisicoRepository repository;
    private final ExercicioFisicoMapper mapper;

    public List<ExercicioFisicoResponseDTO> buscarTodosAprovados() {
        return mapper.toResponseDTOList(repository.findByAprovadoTrue());
    }

}
