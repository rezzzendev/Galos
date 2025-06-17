package github.rezzzedev.CRUD.Galo.repository;

import github.rezzzedev.CRUD.Galo.model.Galo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GaloRepository extends JpaRepository<Galo, Long> {

    List<Galo> findByNome(String nome);
}
