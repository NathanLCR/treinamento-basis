package com.basis.campina.xtarefas.servico.dto;

import com.basis.campina.xtarefas.dominio.enumeration.EnumStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TarefaDTO implements Serializable {

    private Integer id;

    private String nome;

    private LocalDateTime dataConclusao;

    private LocalDateTime dataInicio;

    private EnumStatus status;

    private Integer anexo;

    private Integer responsavel;
}
