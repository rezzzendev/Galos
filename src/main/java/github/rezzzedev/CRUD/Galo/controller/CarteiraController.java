package github.rezzzedev.CRUD.Galo.controller;

import github.rezzzedev.CRUD.Galo.model.Carteira;
import github.rezzzedev.CRUD.Galo.model.Galo;
import github.rezzzedev.CRUD.Galo.repository.CarteiraRepository;
import github.rezzzedev.CRUD.Galo.service.CarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/carteiras")
public class CarteiraController {

    @Autowired
    CarteiraService carteiraService;


    @PostMapping
    public ResponseEntity<Void> salvarCarteira(@RequestBody Carteira carteira) {
        carteiraService.salvarCarteira(carteira);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carteira.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
