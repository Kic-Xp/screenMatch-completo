package br.com.alura.screenmatch.service;


import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<SerieDTO> obterTodasAsSeries() {
        return converteSerieParaDTO(serieRepository.findAll());

    }

    public List<SerieDTO> obterTop5Series() {
        return converteSerieParaDTO(serieRepository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> obterTop5Lancamentos() {
        return converteSerieParaDTO(serieRepository.encontrarEpisodiosMaisRecentes());
    }

    public List<SerieDTO> converteSerieParaDTO(List<Serie> series) {
        return series.stream().
                map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());
    }


    public SerieDTO obterDetalhesSerie(Long id) {
        var s = serieRepository.findById(id);
        if (s.isPresent()) {
            return new SerieDTO(s);
        }
        return null;
    }

    public List<EpisodioDTO> obterTodasAsTemporadas(Long id) {
        var serie =  serieRepository.findById(id);
        if(serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodios()
                    .stream()
                    .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(),
                            e.getTitulo()))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<EpisodioDTO> obterDetalhesTemporada(Long id, Long numero) {
        return serieRepository.obterEpisodiosPorTemporada(id, numero)
                .stream()
                .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> obterSeriePorCategoria(String nomeGenero) {
        Categoria categoria = Categoria.fromPortugues(nomeGenero);
        return converteSerieParaDTO(serieRepository.findByGenero(categoria));
    }

    public List<EpisodioDTO> obterTop5Episodios(Long id) {
        var s =  serieRepository.findById(id);
        if(s.isPresent()){
            Serie serie =  s.get();
            return serieRepository.topEpisodiosPorSerie(serie)
                    .stream()
                    .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
