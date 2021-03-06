package br.fatec.app.modules.v1.recebimento.entity;


import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "itemNotaFiscal")
public class ItemNotaFiscalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
