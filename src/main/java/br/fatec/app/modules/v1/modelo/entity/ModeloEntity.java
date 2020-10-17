package br.fatec.app.modules.v1.modelo.entity;


import br.fatec.app.modules.v1.marca.entity.MarcaEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "modelo")
public class ModeloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(
            name = "nome",
            nullable = false
    )
    private String nome;

    @ManyToOne
    @JoinColumn(name ="MARCA_ID")
    private MarcaEntity marca;

    @Column(
            name = "ativo",
            nullable = false
    )
    private boolean ativo;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MarcaEntity getMarca() {
        return this.marca;
    }

    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
