package br.com.meli.joalheria.controller;

import br.com.meli.joalheria.dto.JoiaResponseDTO;
import br.com.meli.joalheria.model.Joia;
import br.com.meli.joalheria.service.JoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class JoiaController {

    @Autowired
    private JoiaService joiaService;

    @PostMapping("/joias/inserir")
    public ResponseEntity<JoiaResponseDTO> create(@RequestBody Joia joia, UriComponentsBuilder uriBuilder) {
        JoiaResponseDTO joia1 = joiaService.create(joia);
        URI uri = uriBuilder
                .path("/usuarios/{id}")
                .buildAndExpand(joia1.getId())
                .toUri();
        return ResponseEntity.created(uri).body(joia1);
    }

    @GetMapping("/joias/{id}")
    public ResponseEntity<Joia> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(joiaService.findById(id));
    }

    @GetMapping("/joias")
    public ResponseEntity<List<Joia>> findAll() {
        return ResponseEntity.ok(joiaService.findAll());
    }

    @DeleteMapping("/joias/excluir/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        joiaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/joias/atualizar/{id}")
    public ResponseEntity<Joia> update(@PathVariable Integer id,
                       @RequestBody Joia joia) {
        return ResponseEntity.ok(joiaService.update(id, joia));
    }


}
