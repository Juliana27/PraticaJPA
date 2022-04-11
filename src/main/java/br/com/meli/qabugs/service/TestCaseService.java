package br.com.meli.qabugs.service;

import br.com.meli.qabugs.model.TestCase;
import br.com.meli.qabugs.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;


    public TestCase create(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    public List<TestCase> findAll() {
        return testCaseRepository.findAll();
    }


    public TestCase findById(Long id) {
        return testCaseRepository.findById(id).orElse(new TestCase());
    }

    public TestCase update(TestCase testCase, Long id) {
        TestCase saveTestCase = findById(id);
        saveTestCase.setLastUpdate(testCase.getLastUpdate());
        saveTestCase.setDescription(testCase.getDescription());
        saveTestCase.setNumber_of_tries(testCase.getNumber_of_tries());
        if (testCase.isTested()) {
            saveTestCase.setTested(true);
        } else {
            saveTestCase.setTested(false);
        }
        if (testCase.isPassed()) {
            saveTestCase.setPassed(true);
        } else {
            saveTestCase.setPassed(false);
        }
        return testCaseRepository.save(saveTestCase);
    }

    public void delete(Long id) {
        testCaseRepository.deleteById(id);
    }

    public List<TestCase> findByLastUpdate(LocalDate date) {
        return testCaseRepository.findByLastUpdate(date);
    }
}
