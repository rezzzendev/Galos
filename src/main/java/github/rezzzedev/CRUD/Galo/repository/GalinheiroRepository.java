package github.rezzzedev.CRUD.Galo.repository;

import github.rezzzedev.CRUD.Galo.model.Galinheiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalinheiroRepository extends JpaRepository<Galinheiro, Long> {

    public List<Galinheiro> findByNomeGalinheiro(String nomeGalinheiro);
}
