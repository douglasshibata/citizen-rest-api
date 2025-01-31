package br.edu.unyleya.aluno.citizen_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unyleya.aluno.citizen_rest_api.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{
    
}
