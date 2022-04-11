package com.br.meli.storage.ropository;

import com.br.meli.storage.model.Anuncio;
import com.br.meli.storage.model.UF;
import com.br.meli.storage.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

    List<Anuncio> findByVendedor(Vendedor vendedor);

    BigDecimal findByPreco(BigDecimal preco);

    //JPQL
    @Query(value = "from Anuncio a where a.vendedor.endereco.uf =: uf")
    List<Anuncio> retrieveBySellerUF(UF uf);
}
