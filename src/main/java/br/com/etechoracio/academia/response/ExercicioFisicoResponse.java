package br.com.etechoracio.academia.dto.response;

import br.com.etechoracio.academia.enums.NivelDificuldadeEnum;

public record ExercicioFisicoResponse(
        Long id,
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