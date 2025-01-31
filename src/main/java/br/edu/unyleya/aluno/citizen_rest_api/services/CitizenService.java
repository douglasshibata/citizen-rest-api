package br.edu.unyleya.aluno.citizen_rest_api.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.unyleya.aluno.citizen_rest_api.execeptions.NotFoundException;
import br.edu.unyleya.aluno.citizen_rest_api.model.Address;
import br.edu.unyleya.aluno.citizen_rest_api.model.Citizen;
import br.edu.unyleya.aluno.citizen_rest_api.repository.AddressRepository;
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

    public Citizen update(Long id, Citizen citizen) throws NotFoundException {
        Citizen optional = repository.findById(id).orElseThrow(()-> new NotFoundException("Id not found"));
        citizen.setId(optional.getId());
        citizen = repository.save(citizen);
        return citizen;
    }

    public Page<Citizen> findAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    public void delete(Long id) throws NotFoundException {
        Citizen optional = repository.findById(id).orElseThrow(()-> new NotFoundException("Id not found"));
        repository.delete(optional);
    }
}
