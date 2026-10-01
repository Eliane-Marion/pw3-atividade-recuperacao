package br.com.etechoracio.academia.DTO;

import br.com.etechoracio.academia.enums.NivelDificuldadeEnum;

public record ExercicioFisicoRequestDTO(
        String nome,
        String grupoMuscular,
        String imagem,
        String descricao,
        Integer series,
        int repeticoes,
        double cargaSugerida,
        NivelDificuldadeEnum nivelDificuldade
) {
}
