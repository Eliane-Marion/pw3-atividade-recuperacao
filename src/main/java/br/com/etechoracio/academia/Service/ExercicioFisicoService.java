package br.com.etechoracio.academia.Service;


import br.com.etechoracio.academia.DTO.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.DTO.ExercicoFisicoResponseDTO;
import br.com.etechoracio.academia.Mapper.ExercicoFisicoMapper;
import br.com.etechoracio.academia.Repositorio.ExercicioFisicoRepository;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ExercicioFisicoService {
    @Autowired
    private ExercicioFisicoRepository repository;
    @Autowired
    private ExercicoFisicoMapper mapper;

    public List<ExercicoFisicoResponseDTO> listarAprovados() {
        List<ExercicioFisico> exercicios = repository.findByAprovadoTrue();

        return exercicios.stream()
                .map(mapper::toExercicoFisicoResponseDTO)
                .collect(Collectors.toList());
    }

    public ExercicoFisicoResponseDTO buscarPorId(Long id){
        Optional<ExercicioFisico> exercicio = repository.findByIdAndAprovadoTrue(id);

        if(exercicio.isEmpty())
        {
            return null;
        }

        return mapper.toExercicoFisicoResponseDTO(exercicio.get());
    }

    public ExercicoFisicoResponseDTO criar(ExercicioFisicoRequestDTO requestDTO){
        ExercicioFisico exercicio = mapper.toEntity(requestDTO);

        exercicio.setAprovado((false));

        ExercicioFisico salvo = repository.save(exercicio);

        return mapper.toExercicoFisicoResponseDTO(salvo);
    }

    public ExercicoFisicoResponseDTO aprovar(Long id) {

        ExercicioFisico exercicioFisico = repository.findById(id).orElseThrow(() -> new RuntimeException("Exercício físico não encontrado"));

        exercicioFisico.setAprovado(true);

        ExercicioFisico exercicioSalvo =
                repository.save(exercicioFisico);

        return mapper.toExercicoFisicoResponseDTO(exercicioSalvo);
    }
}
