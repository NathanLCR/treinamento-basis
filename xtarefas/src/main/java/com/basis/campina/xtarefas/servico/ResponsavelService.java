package com.basis.campina.xtarefas.servico;

import com.basis.campina.xtarefas.servico.dto.ResponsavelDTO;

import java.util.List;

public interface ResponsavelService {

    List<ResponsavelDTO> listar();

    ResponsavelDTO salvar(ResponsavelDTO dto);

    ResponsavelDTO editar(ResponsavelDTO dto);

    ResponsavelDTO obterPorId(Integer id);

    void excluir(Integer id);

}
