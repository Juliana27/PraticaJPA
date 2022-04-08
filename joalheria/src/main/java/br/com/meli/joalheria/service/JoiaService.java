package br.com.meli.joalheria.service;

import br.com.meli.joalheria.dto.JoiaResponseDTO;
import br.com.meli.joalheria.model.Joia;
import br.com.meli.joalheria.repository.JoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class JoiaService {

    @Autowired
    private JoiaRepository joiaRepository;

    public List<Joia> findAll() {
        return joiaRepository.findAll();
    }

    public JoiaResponseDTO create(Joia joia) {
        Joia saveJoia = joiaRepository.save(joia);
        JoiaResponseDTO joiaResponseDTO = new JoiaResponseDTO();
        joiaResponseDTO.converte(saveJoia);
        return joiaResponseDTO;
    }

    public void delete(Integer id) {
        joiaRepository.deleteById(id);
    }

    public Joia findById(Integer id) {
        return joiaRepository.findById(id).orElse(null);
    }

    public Joia update(Integer id, Joia joia) {
        Joia saveJoia = findById(id);
        saveJoia.setMaterial(joia.getMaterial());
        saveJoia.setPeso(joia.getPeso());
        saveJoia.setQuilates(joia.getQuilates());
        return joiaRepository.save(saveJoia);
    }
}
