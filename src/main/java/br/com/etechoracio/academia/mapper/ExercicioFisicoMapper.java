package br.com.etechoracio.academia.mapper;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDto;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDto;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExercicioFisicoMapper {

    ExercicioFisicoResponseDto toResponseDTO(ExercicioFisico exercicioFisico);

    List<ExercicioFisicoResponseDto> toRespostaDTOList(List<ExercicioFisico> exerciciosFisicos);

    ExercicioFisico toEntity(ExercicioFisicoRequestDto dto);
}