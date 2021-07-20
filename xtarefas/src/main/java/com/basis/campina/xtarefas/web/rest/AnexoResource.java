package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.servico.AnexoService;
import com.basis.campina.xtarefas.servico.dto.AnexoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/anexo")
@AllArgsConstructor
public class AnexoResource {

    private AnexoService anexoService;

    @GetMapping
    public ResponseEntity<List<AnexoDTO>> listar() {
        return ResponseEntity.ok(anexoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnexoDTO> obterPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(anexoService.obterPorId(id));
    }

    @PostMapping
    public  ResponseEntity<AnexoDTO> salvar(@RequestBody AnexoDTO dto) {
        return new ResponseEntity<>(anexoService.salvar(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<AnexoDTO> editar(@RequestBody AnexoDTO dto) {
        return ResponseEntity.ok(anexoService.editar(dto));
    }

    @DeleteMapping("/{id}")
    public void excluit(@PathVariable Integer id) {
        anexoService.excluir(id);
    }
}
