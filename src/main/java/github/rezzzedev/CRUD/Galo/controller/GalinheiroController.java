package github.rezzzedev.CRUD.Galo.controller;

import github.rezzzedev.CRUD.Galo.model.Galinheiro;
import github.rezzzedev.CRUD.Galo.model.Galo;
import github.rezzzedev.CRUD.Galo.service.GalinheiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/galinheiros")
public class GalinheiroController {

    @Autowired
    GalinheiroService service;

    @PostMapping
    public ResponseEntity<Void> salvarGalinheiro (@RequestBody Galinheiro galinheiro) {
        service.salvarGalinheiro(galinheiro);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(galinheiro.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizarGalinheiro(@PathVariable("id") Long id, @RequestBody Galinheiro galinheiro) {
        var idGalinheiro = Long.valueOf(id);
        Optional<Galinheiro> galinheiroOptional = service.obterPorIdGalinheiro(idGalinheiro);

        var galinheiroAtualizado = galinheiroOptional.get();
        galinheiroAtualizado.setNomeGalinheiro(galinheiro.getNomeGalinheiro());
        galinheiroAtualizado.setDescricaoGalinheiro(galinheiro.getDescricaoGalinheiro());
        galinheiroAtualizado.setQtdQuartos(galinheiro.getQtdQuartos());

        service.atualizarGalinheiro(galinheiroAtualizado);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Galinheiro>> pesquisarGalinheiro (@RequestParam String nomeGalinheiro) {
        List<Galinheiro> pesquisaGalinheiro = service.procurarGalinheiro(nomeGalinheiro);

        return ResponseEntity.ok(pesquisaGalinheiro);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        Optional<Galinheiro> galinheiroOptional = service.obterPorIdGalinheiro(id);
        service.deletarGalinheiro(galinheiroOptional.get());

        return  ResponseEntity.noContent().build();
    }
}
