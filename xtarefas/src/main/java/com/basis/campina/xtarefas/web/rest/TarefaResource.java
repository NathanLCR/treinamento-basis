package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.servico.TarefaService;
import com.basis.campina.xtarefas.servico.dto.TarefaDTO;
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
@RequestMapping("/api/tarefa")
@AllArgsConstructor
public class TarefaResource {

    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listar() {
        return ResponseEntity.ok(tarefaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(tarefaService.obterPorId(id));
    }

    @PostMapping
    public  ResponseEntity<TarefaDTO> salvar(@RequestBody TarefaDTO tarefaDTO) {
        return new ResponseEntity<>(tarefaService.salvar(tarefaDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<TarefaDTO> editar(@RequestBody TarefaDTO responsavelDTO) {
        return ResponseEntity.ok(tarefaService.editar(responsavelDTO));
    }

    @DeleteMapping("/{id}")
    public void excluit(@PathVariable Integer id) {
        tarefaService.excluir(id);
    }
}
