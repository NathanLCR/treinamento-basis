package com.basis.campina.xtarefas.servico.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ResponsavelDTO implements Serializable {
    private Integer id;

    private String nome;

    private String email;

    private LocalDate dataNascimento;
}
