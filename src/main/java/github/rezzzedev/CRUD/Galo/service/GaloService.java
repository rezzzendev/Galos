package github.rezzzedev.CRUD.Galo.service;

import github.rezzzedev.CRUD.Galo.dto.GaloDTO;
import github.rezzzedev.CRUD.Galo.model.Galinheiro;
import github.rezzzedev.CRUD.Galo.model.Galo;
import github.rezzzedev.CRUD.Galo.repository.GaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GaloService {


    @Autowired
    GaloRepository repository;

    public Galo salvar(GaloDTO galoDTO) {
        if (galoDTO.getNome() == null || galoDTO.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do galo é obrigatório");
        }

        if (galoDTO.getPeso() == null || galoDTO.getPeso() <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        }
        Galo galo = new Galo();
        galo.setNome(galoDTO.getNome());
        galo.setPeso(galoDTO.getPeso());
        galo.setDescricao(galoDTO.getDescricao());
        galo.setGalinheiros(galoDTO.getGalinheiros());
       return repository.save(galo);
    }

    public Galo atualizar(Long id, Galo galoAtualizado) {

        Galo galoExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Galo não encontrado com id: " + id));

        galoExistente.setNome(galoAtualizado.getNome());
        galoExistente.setPeso(galoAtualizado.getPeso());
        galoExistente.setDescricao(galoAtualizado.getDescricao());
        galoExistente.setGalinheiros(galoAtualizado.getGalinheiros());

        return repository.save(galoExistente);
    }


    public Optional<Galo> obterPorId(Long id) {
       return repository.findById(id);
    }

    public void deletar (Galo galo) { repository.delete(galo);}

    public List<Galo> pesquisar(String nome) {
        return repository.findByNome(nome);
    }

    public List<Galo> listarTodos() {
        return repository.findAll();
    }
}
