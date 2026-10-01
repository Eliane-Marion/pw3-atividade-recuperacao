package br.com.etechoracio.academia.Repositorio;


import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExercicioFisicoRepository extends JpaRepository<ExercicioFisico, Long> {

    List<ExercicioFisico> findByAprovadoTrue();

    Optional<ExercicioFisico> findByIdAndAprovadoTrue(Long id);

}
