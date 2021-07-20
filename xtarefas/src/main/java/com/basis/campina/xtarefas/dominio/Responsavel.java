package com.basis.campina.xtarefas.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "RESPONSAVEL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Responsavel implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESPONSAVEL")
    @SequenceGenerator(name = "SEQ_RESPONSAVEL", sequenceName = "SEQ_RESPONSAVEL", allocationSize = 1)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

}
