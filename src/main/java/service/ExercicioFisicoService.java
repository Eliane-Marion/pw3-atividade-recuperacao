package service;

import dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import mapper.ExercicioFisicoMapper;
import repository.ExercicioFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioFisicoService {

    @Autowired
    private ExercicioFisicoRepository repository;

    @Autowired
    private ExercicioFisicoMapper mapper;

    // Método da Etapa 1
    public List<ExercicioFisicoResponseDTO> listarAprovados() {
        return repository.findByAprovadoTrue().stream()
                .map(mapper::toDTO)
                .toList();
    }

    // Método da Etapa 2
    public Optional<ExercicioFisicoResponseDTO> buscarPorIdAprovado(Long id) {
        return repository.findByIdAndAprovadoTrue(id)
                .map(mapper::toDTO);
    }
}
