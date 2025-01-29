package br.edu.unyleya.aluno.citizen_rest_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unyleya.aluno.citizen_rest_api.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    Page<Citizen> findAll(Pageable pageable);

}
