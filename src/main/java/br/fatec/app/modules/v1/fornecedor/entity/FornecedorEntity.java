package br.fatec.app.modules.v1.fornecedor.entity;


import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "fornecedor")
public class FornecedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(
            name = "cpfCnpj",
            nullable = false
    )
    private String cpfCnpj;

    @Column(
            name = "nome",
            nullable = false
    )
    private String nome;

    @Column(
            name = "telefone",
            nullable = false
    )
    private String telefone;

    @Column(
            name = "celular",
            nullable = false
    )
    private String celular;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

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

    public String getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
