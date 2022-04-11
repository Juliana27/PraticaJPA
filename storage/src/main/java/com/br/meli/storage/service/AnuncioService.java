package com.br.meli.storage.service;

import com.br.meli.storage.model.Anuncio;
import com.br.meli.storage.ropository.AnuncioRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AnuncioService {

    private AnuncioRepository anuncioRepository;

    public Anuncio salvar(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

    public List<Anuncio> listar() {
        return anuncioRepository.findAll();
    }
}
