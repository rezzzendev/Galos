package github.rezzzedev.CRUD.Galo.dto;

import github.rezzzedev.CRUD.Galo.model.Galinheiro;
import github.rezzzedev.CRUD.Galo.model.Galo;
import lombok.Data;

import java.util.List;

@Data
public class GaloDTO {

    private String nome;
    private Integer peso;
    private String descricao;
    private List<Galinheiro> galinheiros;
}
