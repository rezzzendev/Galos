package github.rezzzedev.CRUD.Galo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_galo")
@Data
public class Galo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "descricao")
    private String descricao;
}
