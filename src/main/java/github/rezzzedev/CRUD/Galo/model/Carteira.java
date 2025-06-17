package github.rezzzedev.CRUD.Galo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_carteira")
@Data
public class Carteira {

    @Id
    @Column(name = "id_carteira")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_carteira")
    private String nomeCarteira;

    @Column(name = "saldo")
    private Double saldo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_conta")
    private TipoConta tipoConta;

    @ManyToOne
    @JoinColumn(name = "galo_id", nullable = false)
    private Galo galo;
}
