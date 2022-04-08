package br.com.meli.joalheria.dto;

import br.com.meli.joalheria.model.Joia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoiaResponseDTO {

    private Integer id;

    public JoiaResponseDTO converte(Joia joia) {
        this.id = joia.getId();
        return this;
    }
}
