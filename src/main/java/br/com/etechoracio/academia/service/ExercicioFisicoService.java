package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDto;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDto;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.mapper.ExercicioFisicoMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioFisicoService {

    private final ExercicioFisicoRepository repository;
    private final ExercicioFisicoMapper mapper;

    public ExercicioFisicoService(
        ExercicioFisicoRepository repository,
        ExercicioFisicoMapper mapper
    ){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ExercicioFisicoResponseDto> listar() {
        List<ExercicioFisico> exercicios = repository.findByAprovadoTrue();

        return exercicios.stream().map(mapper::toResponseDto).toList();
    }

    public Optional<ExercicioFisicoResponseDto> buscarPorId(Long id){
         Optional<ExercicioFisico> exercicio = repository.findByIdAndAprovadoTrue(id);

         return exercicio.map(mapper::toResponseDto);
    }

    public ExercicioFisicoResponseDto cadastrar(ExercicioFisicoRequestDto dto){
        ExercicioFisico exercicio = mapper.toEntity(dto);

        exercicio.setAprovado(false);

        ExercicioFisico salvo = repository.save(exercicio);

        return mapper.toResponseDto(salvo);
    }

    public Optional<ExercicioFisicoResponseDto> aprovar(Long id){
        Optional<ExercicioFisico> resultado = repository.findById(id);

        if (resultado.isEmpty()){
            return Optional.empty();
        }

        ExercicioFisico exercicio = resultado.get();

        exercicio.setAprovado(true);

        ExercicioFisico atualizado = repository.save(exercicio);

        return Optional.of(mapper.toResponseDto(atualizado));
    }
}
