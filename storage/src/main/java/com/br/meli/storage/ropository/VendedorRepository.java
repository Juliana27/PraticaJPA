package com.br.meli.storage.ropository;

import com.br.meli.storage.model.Anuncio;
import com.br.meli.storage.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {


}
