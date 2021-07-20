package com.basis.campina.xtarefas.servico.impl;

import com.basis.campina.xtarefas.dominio.Responsavel;
import com.basis.campina.xtarefas.repositorio.ResponsavelRepository;
import com.basis.campina.xtarefas.servico.ResponsavelService;
import com.basis.campina.xtarefas.servico.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.servico.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class ResponsavelServiceImpl implements ResponsavelService {

    private final ResponsavelRepository responsavelRepository;

    private final ResponsavelMapper responsavelMapper;

    @Override
    public List<ResponsavelDTO> listar() {
        return responsavelMapper.toDto(responsavelRepository.findAll());
    }

    @Override
    public ResponsavelDTO salvar(ResponsavelDTO dto) {
        return persistir(dto);
    }

    @Override
    public ResponsavelDTO editar(ResponsavelDTO dto) {
        obterPorId(dto.getId());
        return persistir(dto);
    }

    private ResponsavelDTO persistir(ResponsavelDTO dto) {
        Responsavel entidade = responsavelRepository.save(responsavelMapper.toEntity(dto));
        return responsavelMapper.toDto(entidade);
    }

    @Override
    public ResponsavelDTO obterPorId(Integer id) {
        Responsavel entidade = responsavelRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException());
        return responsavelMapper.toDto(entidade);
    }

    @Override
    public void excluir(Integer id) {
        obterPorId(id);
        responsavelRepository.deleteById(id);
    }
}
