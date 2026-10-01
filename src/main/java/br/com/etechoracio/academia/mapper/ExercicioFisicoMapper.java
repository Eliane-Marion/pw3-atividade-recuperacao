package br.com.etechoracio.academia.mapper;

import br.com.etechoracio.academia.request.ExercicioFisicoRequest;
import br.com.etechoracio.academia.dto.response.ExercicioFisicoResponse;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExercicioFisicoMapper {

    ExercicioFisicoResponse toResponse(ExercicioFisico entity);

    ExercicioFisico toEntity(ExercicioFisicoRequest request);
}