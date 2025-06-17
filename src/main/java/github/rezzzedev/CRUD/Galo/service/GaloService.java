package github.rezzzedev.CRUD.Galo.service;

import github.rezzzedev.CRUD.Galo.model.Galo;
import github.rezzzedev.CRUD.Galo.repository.GaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GaloService {


    @Autowired
    GaloRepository repository;
    /*public GaloService(GaloRepository repository) {
        this.repository = repository;
    }*/

    public Galo salvar(Galo galo) {
       return repository.save(galo);
    }

    public void atualizar(Galo galo) {
        repository.save(galo);
    }

    public Optional<Galo> obterPorId(Long id) {
       return repository.findById(id);
    }
}
