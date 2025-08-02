package github.rezzzedev.CRUD.Galo.controller;

import github.rezzzedev.CRUD.Galo.dto.GalinheiroDTO;
import github.rezzzedev.CRUD.Galo.model.Galinheiro;
import github.rezzzedev.CRUD.Galo.service.GalinheiroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/galinheiros")
public class GalinheiroController {

    @Autowired
    GalinheiroService galinheiroService;

    @PostMapping
    public ResponseEntity<Galinheiro> salvarGalinheiro (@RequestBody GalinheiroDTO galinheiroDTO) {
        Galinheiro novoGalinheiro = galinheiroService.salvar(galinheiroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoGalinheiro);
    }

    @GetMapping
    public ResponseEntity<List<Galinheiro>> buscarGalinheiro (@RequestParam String nomeGalinheiro) {
        List<Galinheiro> resultadoGalinheiro = galinheiroService.pesquisar(nomeGalinheiro);
        return ResponseEntity.ok(resultadoGalinheiro);
    }

    @DeleteMapping("{id_galinheiro}")
    public ResponseEntity<Void> deletarGalinheiro (@PathVariable("id_galinheiro") Long id) {
        galinheiroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Galinheiro>> listarTodos() {
        List<Galinheiro> galinheiros = galinheiroService.listarTodos();
        return ResponseEntity.ok(galinheiros);
    }
}
