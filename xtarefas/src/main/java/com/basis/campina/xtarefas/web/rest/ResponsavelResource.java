package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.dominio.Responsavel;
import com.basis.campina.xtarefas.servico.ResponsavelService;
import com.basis.campina.xtarefas.servico.dto.ResponsavelDTO;
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
@RequestMapping("/api/responsavel")
@AllArgsConstructor
public class ResponsavelResource {

    private final ResponsavelService responsavelService;

    @GetMapping
    public ResponseEntity<List<ResponsavelDTO>> listar() {
        return ResponseEntity.ok(responsavelService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelDTO> obterPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(responsavelService.obterPorId(id));
    }

    @PostMapping
    public  ResponseEntity<ResponsavelDTO> salvar(@RequestBody ResponsavelDTO responsavelDTO) {
        return new ResponseEntity<>(responsavelService.salvar(responsavelDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<ResponsavelDTO> editar(@RequestBody ResponsavelDTO responsavelDTO) {
        return ResponseEntity.ok(responsavelService.editar(responsavelDTO));
    }

    @DeleteMapping("/{id}")
    public void excluit(@PathVariable Integer id) {
        responsavelService.excluir(id);
    }
}
