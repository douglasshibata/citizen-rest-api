package br.edu.unyleya.aluno.citizen_rest_api.model;

import br.edu.unyleya.aluno.citizen_rest_api.enums.SexoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Data
@Getter
@Setter
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique= true)
    private String cpf;

    private String nome;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
    //endereco 
}
