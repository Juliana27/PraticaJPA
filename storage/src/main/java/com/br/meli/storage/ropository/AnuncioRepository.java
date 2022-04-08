package com.br.meli.storage.ropository;

import com.br.meli.storage.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
}
