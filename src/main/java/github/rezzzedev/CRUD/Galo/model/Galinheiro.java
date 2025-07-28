package github.rezzzedev.CRUD.Galo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_galinheiro")
public class Galinheiro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeGalinheiro")
    private String nomeGalinheiro;

    @Column(name = "descricaoGalinheiro")
    private String descricaoGalinheiro;

    @Column(name = "qtdQuartos")
    private Integer qtdQuartos;

}
