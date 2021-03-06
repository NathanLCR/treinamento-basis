package com.basis.campina.xtarefas.dominio;

import com.basis.campina.xtarefas.dominio.enumeration.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "TAREFA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarefa{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAREFA")
    @SequenceGenerator(name = "SEQ_TAREFA", sequenceName = "SEQ_TAREFA", allocationSize = 1)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_CONCLUSAO")
    private LocalDateTime dataConclusao;

    @Column(name = "DATA_INICIO")
    private LocalDateTime dataInicio;

    @Column(name = "STATUS_COD")
    @Enumerated(EnumType.ORDINAL)
    private EnumStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANEXO_ID", referencedColumnName = "ID")
    private Anexo anexo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESPONSAVEL_ID", referencedColumnName = "ID")
    private Responsavel responsavel;
}
