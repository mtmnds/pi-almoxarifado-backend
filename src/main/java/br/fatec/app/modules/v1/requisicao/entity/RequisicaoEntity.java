package br.fatec.app.modules.v1.requisicao.entity;


import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(
            name = "idItemRequisicao"
    )
    private List<ItemRequisicaoEntity> itens;

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

}
