package br.com.haraujo.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CARRO" )
public class Carro {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
    @SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 100, nullable = false, unique = true)
    private String codigo;

    @Column(name = "MODELO", length = 100, nullable = false)
    private String modelo;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_acessorio_fk",
            foreignKey = @ForeignKey(name = "fk_acessorio_carro"),
            referencedColumnName = "id", nullable = false
    )
    private Acessorio acessorio;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "TB_CARRO_ACESSORIO",
            joinColumns = { @JoinColumn(name = "id_carro_fk") },
            inverseJoinColumns = { @JoinColumn(name = "id_acessorio_fk") }
    )
    private List<Acessorio> acessorios;

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void add(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }


    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


}
