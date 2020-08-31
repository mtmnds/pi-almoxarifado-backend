package br.fatec.app.modules.v1.recebimento.entity;


import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "recebimento")
public class RecebimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private NotaFiscalEntity notaFiscal;

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

    public NotaFiscalEntity getNotaFiscal() {
        return this.notaFiscal;
    }

    public void setNotaFiscal(NotaFiscalEntity notaFiscal) {
        this.notaFiscal = notaFiscal;
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
