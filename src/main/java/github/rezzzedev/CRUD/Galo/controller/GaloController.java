package github.rezzzedev.CRUD.Galo.controller;

import github.rezzzedev.CRUD.Galo.dto.GaloDTO;
import github.rezzzedev.CRUD.Galo.model.Galinheiro;
import github.rezzzedev.CRUD.Galo.model.Galo;
import github.rezzzedev.CRUD.Galo.repository.GaloRepository;
import github.rezzzedev.CRUD.Galo.service.GaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/galos")
public class GaloController {




    @Autowired
    private GaloService service;

    @Autowired
    private GaloRepository galoRepository;


    @PostMapping
    public ResponseEntity<Galo> criarGalo(@RequestBody GaloDTO dto) {
            Galo novoGalo = service.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoGalo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Galo> atualizar(
            @PathVariable("id") Long id,
            @RequestBody Galo galo) {

        Galo atualizado = service.atualizar(id, galo);
        return ResponseEntity.ok(atualizado);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        var idGalo = Long.valueOf(id);
        Optional<Galo> galoOptional = service.obterPorId(idGalo);

        service.deletar(galoOptional.get());

        return  ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Galo>> pesquisa(@RequestParam String nome) {
        List<Galo> resultado = service.pesquisar(nome);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Galo>> listarTodos() {
        List<Galo> galos = service.listarTodos();
        return ResponseEntity.ok(galos);
    }
}
