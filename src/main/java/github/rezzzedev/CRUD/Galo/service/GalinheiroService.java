package github.rezzzedev.CRUD.Galo.service;

import github.rezzzedev.CRUD.Galo.model.Galinheiro;
import github.rezzzedev.CRUD.Galo.repository.GalinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalinheiroService {

    @Autowired
    GalinheiroRepository repository;

    public Galinheiro salvarGalinheiro(Galinheiro galinheiro) {
        return repository.save(galinheiro);
    }

    public void atualizarGalinheiro(Galinheiro galinheiro) {
        repository.save(galinheiro);
    }

    public Optional<Galinheiro> obterPorIdGalinheiro(Long id) {
        return repository.findById(id);
    }

    public List<Galinheiro> procurarGalinheiro (String nomeGalinheiro) {
        return repository.findByNomeGalinheiro(nomeGalinheiro);
    }

    public void deletarGalinheiro (Galinheiro galinheiro) {
        repository.delete(galinheiro);
    }

}
