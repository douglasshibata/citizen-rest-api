package br.edu.unyleya.aluno.citizen_rest_api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unyleya.aluno.citizen_rest_api.execeptions.ResourceNotFoundException;
import br.edu.unyleya.aluno.citizen_rest_api.model.Citizen;
import br.edu.unyleya.aluno.citizen_rest_api.services.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/citizen")
@RequiredArgsConstructor
public class CitizenController {

    private final CitizenService service;

    @GetMapping
    public ResponseEntity<Page<Citizen>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
    @GetMapping("{id}")
    public ResponseEntity<Citizen> findByUd(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping()
    public ResponseEntity<Citizen> save(@RequestBody Citizen entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("{id}")
    public ResponseEntity<Citizen> update(@PathVariable Long id, @RequestBody Citizen entity) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.update(id, entity));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Citizen> delete(@PathVariable Long id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
