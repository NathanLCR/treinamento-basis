package com.basis.campina.xtarefas.servico.impl;

import com.basis.campina.xtarefas.dominio.Tarefa;
import com.basis.campina.xtarefas.repositorio.TarefaRepository;
import com.basis.campina.xtarefas.servico.TarefaService;
import com.basis.campina.xtarefas.servico.dto.TarefaDTO;
import com.basis.campina.xtarefas.servico.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    private final TarefaMapper tarefaMapper;

    @Override
    public List<TarefaDTO> listar() {
        return tarefaMapper.toDto(tarefaRepository.findAll());
    }

    @Override
    public TarefaDTO salvar(TarefaDTO dto) {
        return persistir(dto);
    }

    @Override
    public TarefaDTO editar(TarefaDTO dto) {
        obterPorId(dto.getId());
        return persistir(dto);
    }

    private TarefaDTO persistir(TarefaDTO dto) {
        Tarefa entidade = tarefaRepository.save(tarefaMapper.toEntity(dto));
        return tarefaMapper.toDto(entidade);
    }

    @Override
    public TarefaDTO obterPorId(Integer id) {
        Tarefa entidade = tarefaRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException());
        return tarefaMapper.toDto(entidade);
    }

    @Override
    public void excluir(Integer id) {
        tarefaRepository.deleteById(id);
    }
}
