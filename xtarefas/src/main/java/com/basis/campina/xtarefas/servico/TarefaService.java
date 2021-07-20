package com.basis.campina.xtarefas.servico;

import com.basis.campina.xtarefas.servico.dto.TarefaDTO;

import java.util.List;

public interface TarefaService {

    List<TarefaDTO> listar();

    TarefaDTO salvar(TarefaDTO dto);

    TarefaDTO editar(TarefaDTO dto);

    TarefaDTO obterPorId(Integer id);

    void excluir(Integer id);
}
