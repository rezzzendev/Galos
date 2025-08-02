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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_galos_galinheiros",
            joinColumns = @JoinColumn(name = "galo_id"),
            inverseJoinColumns = @JoinColumn(name = "galinheiro_id")
    )
    private List<Galinheiro> galinheiros;
}
