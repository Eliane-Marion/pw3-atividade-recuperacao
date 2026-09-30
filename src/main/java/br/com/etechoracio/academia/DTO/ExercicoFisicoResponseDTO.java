package br.com.etechoracio.academia.DTO;

import br.com.etechoracio.academia.enums.NivelDificuldadeEnum;


public record ExercicoFisicoResponseDTO(

        Long id,
        String nome,
        String grupoMuscular,
        String imagem,
        String descricao,
        Integer series,
        Integer repeticoes,
        Double cargaSugerida,
        NivelDificuldadeEnum nivelDificuldade
){}
