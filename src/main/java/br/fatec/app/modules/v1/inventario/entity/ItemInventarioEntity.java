package br.fatec.app.modules.v1.inventario.entity;

import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "itemInventario")
public class ItemInventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private InventarioEntity inventario;

    @ManyToOne
    private MaterialEntity material;

    @ManyToOne
    private LocalEstoqueEntity localEstoque;

    @Column(
            name = "quantidade",
            nullable = false
    )
    private float quantidade;

    @ManyToOne
    private UsuarioEntity usuarioContagem;

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

    public InventarioEntity getInventario() {
        return this.inventario;
    }

    public void setInventario(InventarioEntity inventario) {
        this.inventario = inventario;
    }

    public MaterialEntity getMaterial() {
        return this.material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    public LocalEstoqueEntity getLocalEstoque() {
        return this.localEstoque;
    }

    public void setLocalEstoque(LocalEstoqueEntity localEstoque) {
        this.localEstoque = localEstoque;
    }

    public float getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public UsuarioEntity getUsuarioContagem() {
        return this.usuarioContagem;
    }

    public void setUsuarioContagem(UsuarioEntity usuarioContagem) {
        this.usuarioContagem = usuarioContagem;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
