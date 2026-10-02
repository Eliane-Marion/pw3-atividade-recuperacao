package br.com.etechoracio.academia.mapper;

import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;
import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ExercicioFisicoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aprovado", ignore = true)
    ExercicioFisico toEntity(
            ExercicioFisicoRequestDTO exercicioFisicoRequestDTO);

    List<ExercicioFisicoResponseDTO> toResponseDTOList(
            List<ExercicioFisico> exercicios);

    ExercicioFisicoResponseDTO toResponseDTO(
            ExercicioFisico exercicio);

}