package br.edu.unyleya.aluno.citizen_rest_api.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.unyleya.aluno.citizen_rest_api.execeptions.ResourceNotFoundException;
import br.edu.unyleya.aluno.citizen_rest_api.model.Citizen;
import br.edu.unyleya.aluno.citizen_rest_api.repository.CitizenRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitizenService {

    private final CitizenRepository repository;

    public List<Citizen> findAll() {
        return repository.findAll();
    }

    public Citizen save(Citizen citizen) {

        return repository.save(citizen);
    }

    public Citizen update(Long id, Citizen citizen) throws ResourceNotFoundException {
        Citizen optional = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
        citizen.setId(optional.getId());
        citizen = repository.save(citizen);
        return citizen;
    }

    public Page<Citizen> findAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    public void delete(Long id) throws ResourceNotFoundException {
        Citizen optional = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
        repository.delete(optional);
    }

    public Citizen findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
    }
}
