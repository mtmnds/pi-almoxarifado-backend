package br.fatec.app.modules.v1.inventario.entity;


import br.fatec.app.modules.v1.inventario.entity.ItemInventarioEntity;
import br.fatec.app.modules.v1.inventario.entity.ItemInventarioEntity;
import br.fatec.app.modules.v1.inventario.entity.ItemInventarioEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity(name = "inventario")
public class InventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private TipoInventarioEntity tipoInventario;

    @ManyToOne
    private StatusInventarioEntity statusInventario;

    @Column(
            name = "descricao",
            nullable = false
    )
    private String descricao;

    @Column(
            name = "dataInicio"
    )
    private Date dataInicio;

    @Column(
            name = "dataFim"
    )
    private Date dataFim;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(
            name = "idInventario"
    )
    private List<ItemInventarioEntity> itens;
    
    @ManyToOne
    private UsuarioEntity usuarioCriacao;

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

    public TipoInventarioEntity getTipoInventario() {
        return this.tipoInventario;
    }

    public void setTipoInventario(TipoInventarioEntity tipoInventario) {
        this.tipoInventario = tipoInventario;
    }

    public StatusInventarioEntity getStatusInventario() {
        return this.statusInventario;
    }

    public void setStatusInventario(StatusInventarioEntity statusInventario) {
        this.statusInventario = statusInventario;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public List<ItemInventarioEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemInventarioEntity> itens) {
        this.itens = itens;
    }

    public UsuarioEntity getUsuarioCriacao() {
        return this.usuarioCriacao;
    }

    public void setUsuarioCriacao(UsuarioEntity usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
