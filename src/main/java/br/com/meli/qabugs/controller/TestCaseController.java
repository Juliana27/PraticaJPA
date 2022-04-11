package br.com.meli.qabugs.controller;

import br.com.meli.qabugs.model.TestCase;
import br.com.meli.qabugs.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<TestCase> create(@RequestBody TestCase testCase) {
        return new ResponseEntity<>(testCaseService.create(testCase), HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCase>> findAll() {
        return ResponseEntity.ok(testCaseService.findAll());
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> findById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.findById(id));
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> update(@RequestBody TestCase testCase,
                                           @PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.update(testCase, id));
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        testCaseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/testcases/lastUpdate/{date}")
    public ResponseEntity<List<TestCase>> findByLastUpdate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(testCaseService.findByLastUpdate(date));
    }
}
