package com.basis.campina.xtarefas.servico.mapper;

import com.basis.campina.xtarefas.dominio.Anexo;
import com.basis.campina.xtarefas.servico.dto.AnexoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnexoMapper extends EntityMapper<AnexoDTO, Anexo>{
}
