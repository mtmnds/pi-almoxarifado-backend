package br.fatec.app.modules.v1.estoque.entity;


import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "estoque")
public class EstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private LocalEstoqueEntity localEstoque;

    @ManyToOne
    private MaterialEntity material;

    @Column(
            name = "quantidade",
            nullable = false
    )
    private float quantidade;

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

    public LocalEstoqueEntity getLocalEstoque() {
        return this.localEstoque;
    }

    public void setLocalEstoque(LocalEstoqueEntity localEstoque) {
        this.localEstoque = localEstoque;
    }

    public MaterialEntity getMaterial() {
        return this.material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    public float getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
