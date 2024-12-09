package br.com.haraujo.domain;


import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="marca_seq")
    @SequenceGenerator(name="marca_seq", sequenceName="sq_marca", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 100, nullable = false, unique = true)
    private String codigo;

    @Column(name = "FABRICANTE", length = 100, nullable = false)
    private String fabricante;

    @ManyToOne
    @JoinColumn(name = "id_carro_fk",
            foreignKey = @ForeignKey(name = "fk_carro_marca"),
            referencedColumnName = "id", nullable = false
    )
    private Carro carro;


    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


}
