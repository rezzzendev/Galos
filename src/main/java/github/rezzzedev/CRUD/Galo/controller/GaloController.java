package github.rezzzedev.CRUD.Galo.controller;

import github.rezzzedev.CRUD.Galo.dto.GaloDTO;
import github.rezzzedev.CRUD.Galo.model.Carteira;
import github.rezzzedev.CRUD.Galo.model.Galo;
import github.rezzzedev.CRUD.Galo.repository.GaloRepository;
import github.rezzzedev.CRUD.Galo.service.GaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public Galo criarGalo(@RequestBody GaloDTO dto) {
        Galo galo = new Galo();
        galo.setNome(dto.getNome());
        galo.setPeso(dto.getPeso());
        galo.setDescricao(dto.getDescricao());


        List<Carteira> carteiras = dto.getCarteiras().stream().map(c -> {
            Carteira carteira = new Carteira();
            carteira.setNomeCarteira(c.getNomeCarteira());
            carteira.setSaldo(c.getSaldo());
            carteira.setTipoConta(c.getTipoConta());
            carteira.setGalo(galo);
            return carteira;
        }).toList();

        galo.setCarteiras(carteiras);

        return galoRepository.save(galo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Galo galo) {
        //var idGalo = Long.valueOf(id);
        Optional<Galo> galoOptional = service.obterPorId(id);

        var galoAtualizado = galoOptional.get();
        galoAtualizado.setNome(galo.getNome());
        galoAtualizado.setPeso(galo.getPeso());
        galoAtualizado.setDescricao(galo.getDescricao());

        service.atualizar(galoAtualizado);

        return ResponseEntity.noContent().build();
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
}
