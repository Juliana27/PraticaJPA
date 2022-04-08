package br.com.meli.joalheria.repository;

import br.com.meli.joalheria.model.Joia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoiaRepository extends JpaRepository<Joia, Integer> {
}
