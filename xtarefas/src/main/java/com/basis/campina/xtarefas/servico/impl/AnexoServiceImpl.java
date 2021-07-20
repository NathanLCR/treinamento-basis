package com.basis.campina.xtarefas.servico.impl;

import com.basis.campina.xtarefas.dominio.Anexo;
import com.basis.campina.xtarefas.repositorio.AnexoRepository;
import com.basis.campina.xtarefas.servico.AnexoService;
import com.basis.campina.xtarefas.servico.dto.AnexoDTO;
import com.basis.campina.xtarefas.servico.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class AnexoServiceImpl implements AnexoService {

    private final AnexoRepository anexoRepository;

    private final AnexoMapper anexoMapper;

    @Override
    public List<AnexoDTO> listar() {
        return anexoMapper.toDto(anexoRepository.findAll());
    }

    @Override
    public AnexoDTO salvar(AnexoDTO dto) {
        return persistir(dto);
    }

    @Override
    public AnexoDTO editar(AnexoDTO dto) {
        obterPorId(dto.getId());
        return persistir(dto);
    }

    private AnexoDTO persistir(AnexoDTO dto) {
        Anexo entidade = anexoRepository.save(anexoMapper.toEntity(dto));
        return anexoMapper.toDto(entidade);
    }

    @Override
    public AnexoDTO obterPorId(Integer id) {
        Anexo entidade = anexoRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException());
        return anexoMapper.toDto(entidade);
    }

    @Override
    public void excluir(Integer id) {
        anexoRepository.deleteById(id);
    }
}
