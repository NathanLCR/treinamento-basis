package com.basis.campina.xtarefas.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ANEXO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Anexo implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ANEXO")
    @SequenceGenerator(name = "SEQ_ANEXO", sequenceName = "SEQ_ANEXO", allocationSize = 1)
    private Integer id;

    @Column(name = "FILE")
    private String file;

    @Column(name = "FILE_NAME")
    private String fileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAREFA_ID")
    private Tarefa tarefa;
}
