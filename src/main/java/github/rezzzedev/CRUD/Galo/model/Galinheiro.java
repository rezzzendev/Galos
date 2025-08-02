package github.rezzzedev.CRUD.Galo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

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

    @ManyToMany(mappedBy = "galinheiros")
    @JsonIgnore
    private List<Galo> galos;
}
