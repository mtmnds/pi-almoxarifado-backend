package br.fatec.app.modules.v1.requisicao.entity;


import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "requisicao")
public class RequisicaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private StatusRequisicaoEntity statusRequisicao;

    @ManyToOne
    private UsuarioEntity solicitante;

    @Column(
            name = "dataSolicitacao",
            nullable = false
    )
    private Date dataSolicitacao;

    @ManyToOne
    private MaterialEntity material;

    @Column(
            name = "quantidade",
            nullable = false
    )
    private float quantidade;

    @ManyToOne
    private UsuarioEntity atendente;

    @Column(
            name = "dataAtendimento",
            nullable = true
    )
    private Date dataAtendimento;

    @Column(
            name = "ativo",
            nullable = false
    )
    private boolean ativo;

    @Column(
            name = "dataCadastro",
            nullable = false
    )
    private Date dataCadastro;

    @ManyToOne
    private UsuarioEntity usuarioCadastro;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StatusRequisicaoEntity getStatusRequisicao() {
        return this.statusRequisicao;
    }

    public void setStatusRequisicao(StatusRequisicaoEntity statusRequisicao) {
        this.statusRequisicao = statusRequisicao;
    }

    public UsuarioEntity getSolicitante() {
        return this.solicitante;
    }

    public void setSolicitante(UsuarioEntity solicitante) {
        this.solicitante = solicitante;
    }

    public Date getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
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

    public UsuarioEntity getAtendente() {
        return this.atendente;
    }

    public void setAtendente(UsuarioEntity atendente) {
        this.atendente = atendente;
    }

    public Date getDataAtendimento() {
        return this.dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public UsuarioEntity getUsuarioCadastro() {
        return this.usuarioCadastro;
    }

    public void setUsuarioCadastro(UsuarioEntity usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }
}
