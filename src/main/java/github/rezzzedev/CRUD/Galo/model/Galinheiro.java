package github.rezzzedev.CRUD.Galo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_galinheiro")
@Data
public class Galinheiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_galinheiro")
    private Long id;

    @Column(name = "nome_galinheiro")
    private String nomeGalinheiro;

    @Column(name = "descricao_galinheiro")
    private String descricaoGalinheiro;
}
