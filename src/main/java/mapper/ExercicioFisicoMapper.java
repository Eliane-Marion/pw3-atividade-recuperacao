package mapper;

import dto.ExercicioFisicoRequestDTO;
import dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExercicioFisicoMapper {

    ExercicioFisicoResponseDTO toDTO(ExercicioFisico entity);
    ExercicioFisico toEntity(ExercicioFisicoRequestDTO dto);
}