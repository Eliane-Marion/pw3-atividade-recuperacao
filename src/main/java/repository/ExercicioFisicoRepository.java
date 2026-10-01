package repository;

import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ExercicioFisicoRepository extends JpaRepository<ExercicioFisico, Long> {

    // Etapa 1: Busca apenas aprovados
    List<ExercicioFisico> findByAprovadoTrue();

    // Etapa 2: Busca por ID e apenas se for aprovado
    Optional<ExercicioFisico> findByIdAndAprovadoTrue(Long id);
}
