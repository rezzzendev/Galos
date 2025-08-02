package github.rezzzedev.CRUD.Galo.dto;

import github.rezzzedev.CRUD.Galo.model.Galo;
import lombok.Data;
import java.util.List;

@Data
public class GalinheiroDTO {

    private String nomeGalinheiro;
    private String descricaoGalinheiro;
    private List<Galo> galos;
}
