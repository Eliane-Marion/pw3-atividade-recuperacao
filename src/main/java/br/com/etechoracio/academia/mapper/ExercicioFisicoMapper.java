package br.com.etechoracio.academia.mapper;

public class ExercicioFisicoMapper @Mapper(componentModel = "spring"){


    ExercicioFisicoResponse toResponse(ExercicioFisico entity);

    ExercicioFisico toEntity(ExercicioFisicoRequest request);

}
