package github.rezzzedev.CRUD.Galo.dto;

import github.rezzzedev.CRUD.Galo.model.TipoConta;
import lombok.Data;

@Data
public class CarteiraDTO {

    private String nomeCarteira;
    private Double saldo;
    private TipoConta tipoConta;
}
