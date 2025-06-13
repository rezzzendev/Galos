package github.rezzzedev.CRUD.Galo.service;

import github.rezzzedev.CRUD.Galo.model.Galo;
import github.rezzzedev.CRUD.Galo.repository.GaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GaloService {


    @Autowired
    GaloRepository repository;
    /*public GaloService(GaloRepository repository) {
        this.repository = repository;
    }*/

    public void salvar(Galo galo) {
        repository.save(galo);
    }
}
