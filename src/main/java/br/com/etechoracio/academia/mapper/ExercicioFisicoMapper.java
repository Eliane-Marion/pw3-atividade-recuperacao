package br.com.etechoracio.academia.mapper;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExercicioFisicoMapper {

    ExercicioFisicoResponseDTO toResponseDTO(ExercicioFisico exercicioFisico);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aprovado", ignore = true)
    ExercicioFisico toEntity(ExercicioFisicoRequestDTO requestDTO);
}
