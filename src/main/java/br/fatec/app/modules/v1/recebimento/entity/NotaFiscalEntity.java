package br.fatec.app.modules.v1.recebimento.entity;

import br.fatec.app.modules.v1.fornecedor.entity.FornecedorEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "notaFiscal")
public class NotaFiscalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(
            name = "numero",
            nullable = false
    )
    private int numero;

    @Column(
            name = "serie",
            nullable = false
    )
    private int serie;

    @ManyToOne
    private FornecedorEntity fornecedorEntity;

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

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSerie() {
        return this.serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public FornecedorEntity getFornecedorEntity() {
        return this.fornecedorEntity;
    }

    public void setFornecedorEntity(FornecedorEntity fornecedorEntity) {
        this.fornecedorEntity = fornecedorEntity;
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
