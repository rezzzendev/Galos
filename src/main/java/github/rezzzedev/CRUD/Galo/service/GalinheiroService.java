package github.rezzzedev.CRUD.Galo.service;

import github.rezzzedev.CRUD.Galo.dto.GalinheiroDTO;
import github.rezzzedev.CRUD.Galo.model.Galinheiro;
import github.rezzzedev.CRUD.Galo.model.Galo;
import github.rezzzedev.CRUD.Galo.repository.GalinheiroRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalinheiroService {

    @Autowired
    GalinheiroRepository galinheiroRepository;

    public Galinheiro salvar (GalinheiroDTO galinheiroDTO) {
        Galinheiro galinheiro = new Galinheiro();
        galinheiro.setNomeGalinheiro(galinheiroDTO.getNomeGalinheiro());
        galinheiro.setDescricaoGalinheiro(galinheiroDTO.getDescricaoGalinheiro());
        galinheiro.setGalos(galinheiroDTO.getGalos());

        return galinheiroRepository.save(galinheiro);
    }
    public Optional<Galinheiro> obterPorId(Long id) {
        return galinheiroRepository.findById(id);
    }

    public List<Galinheiro> listarTodos() {
        return galinheiroRepository.findAll();
    }

    public List<Galinheiro> pesquisar (String nomeGalinheiro) {
        return galinheiroRepository.findByNomeGalinheiro(nomeGalinheiro);
    }

    public void deletar (Long id) {
        galinheiroRepository.deleteById(id);
    }
}
