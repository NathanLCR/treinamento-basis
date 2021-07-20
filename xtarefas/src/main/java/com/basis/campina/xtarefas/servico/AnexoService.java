package com.basis.campina.xtarefas.servico;

import com.basis.campina.xtarefas.servico.dto.AnexoDTO;

import java.util.List;

public interface AnexoService {
    List<AnexoDTO> listar();

    AnexoDTO salvar(AnexoDTO dto);

    AnexoDTO editar(AnexoDTO dto);

    AnexoDTO obterPorId(Integer id);

    void excluir(Integer id);
}
