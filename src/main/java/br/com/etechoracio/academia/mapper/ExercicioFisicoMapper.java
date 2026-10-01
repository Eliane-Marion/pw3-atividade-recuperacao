package br.com.etechoracio.academia.mapper;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExercicioFisicoMapper {

    ExercicioFisicoResponseDTO toResponseDTO(ExercicioFisico exercicioFisico);

    List<ExercicioFisicoResponseDTO> toResponseDTOList(List<ExercicioFisico> exerciciosFisicos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aprovado", ignore = true)
    ExercicioFisico toEntity(ExercicioFisicoRequestDTO requestDTO);

}
