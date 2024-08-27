package br.com.alura.screenmatch.dto;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Serie;

import java.util.Optional;

public record SerieDTO(
        Long id,
        String titulo,
        Integer totalTemporadas,
        Double avaliacao,
        Categoria genero,
        String atores,
        String poster,
        String sinopse) {
    public SerieDTO(Optional<Serie> serie) {
        this(serie.get().getId(), serie.get().getTitulo(), serie.get().getTotalTemporadas(),
                serie.get().getAvaliacao(), serie.get().getGenero(), serie.get().getAtores(), serie.get().getPoster(), serie.get().getSinopse());
    }
}
