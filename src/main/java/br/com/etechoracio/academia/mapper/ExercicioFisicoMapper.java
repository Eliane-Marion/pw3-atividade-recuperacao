package br.com.etechoracio.academia.mapper;


import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDto;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExercicioFisicoMapper {
    ExercicioFisico toEntity(ExercicioFisicoResponseDto dto);
    ExercicioFisicoResponseDto toResponseDto(ExercicioFisicoResponseDto entity);

}
