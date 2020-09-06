package br.fatec.app.modules.v1.movimentacao.entity;


import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "movimentacao")
public class MovimentacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private MaterialEntity material;

    @ManyToOne
    private LocalEstoqueEntity localOrigem;

    @ManyToOne
    private LocalEstoqueEntity localDestino;

    @Column(
            name = "quantidade",
            nullable = false
    )
    private float quantidade;

    @Column(
            name = "dataMovimentacao",
            nullable = false
    )
    private Date dataMovimentacao;

    @ManyToOne
    private UsuarioEntity usuarioMovimentacao;

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

    public LocalEstoqueEntity getLocalOrigem() {
        return this.localOrigem;
    }

    public void setLocalOrigem(LocalEstoqueEntity localOrigem) {
        this.localOrigem = localOrigem;
    }

    public LocalEstoqueEntity getLocalDestino() {
        return this.localDestino;
    }

    public void setLocalDestino(LocalEstoqueEntity localDestino) {
        this.localDestino = localDestino;
    }

    public float getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataMovimentacao() {
        return this.dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public UsuarioEntity getUsuarioMovimentacao() {
        return this.usuarioMovimentacao;
    }

    public void setUsuarioMovimentacao(UsuarioEntity usuarioMovimentacao) {
        this.usuarioMovimentacao = usuarioMovimentacao;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
