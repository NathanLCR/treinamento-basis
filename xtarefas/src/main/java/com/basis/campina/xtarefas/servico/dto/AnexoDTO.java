package com.basis.campina.xtarefas.servico.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AnexoDTO implements Serializable {

    private Integer id;

    private String file;

    private String fileName;
}
