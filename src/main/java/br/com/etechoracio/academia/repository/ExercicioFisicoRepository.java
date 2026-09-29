package br.com.etechoracio.academia.repository;

import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExercicioFisicoRepository extends JpaRepository<ExercicioFisico, Long> {

    List<ExercicioFisico> findByAprovadoTrue();

    Optional<ExercicioFisico> findByIdAndAprovadoTrue(Long id);
}
