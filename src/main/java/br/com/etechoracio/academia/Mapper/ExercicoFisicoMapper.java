package br.com.etechoracio.academia.Mapper;


import br.com.etechoracio.academia.DTO.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.DTO.ExercicoFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExercicoFisicoMapper {

    ExercicoFisicoResponseDTO toExercicoFisicoResponseDTO(ExercicioFisico exercicioFisico);

    ExercicioFisico toEntity( ExercicioFisicoRequestDTO requestDTO);
}
