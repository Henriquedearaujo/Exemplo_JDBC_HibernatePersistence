package br.com.haraujo.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="acessorio_seq")
    @SequenceGenerator(name="acessorio_seq", sequenceName="sq_acessorio", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 100, nullable = false, unique = true)
    private String codigo;

    @Column(name = "TIPO", length = 100, nullable = false)
    private String tipo;

    @ManyToMany(mappedBy = "acessorio")
    private List<Carro> carros;

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public void add(Carro carro) {
        this.carros.add(carro);
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
