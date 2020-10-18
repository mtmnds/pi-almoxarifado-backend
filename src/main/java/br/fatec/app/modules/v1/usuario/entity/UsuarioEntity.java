package br.fatec.app.modules.v1.usuario.entity;


import br.fatec.app.modules.v1.perfil.entity.PerfilEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(
            name = "nome",
            nullable = false
    )
    private String nome;

    @Column(
            name = "cpfCnpj",
            nullable = false
    )
    private String cpfCnpj;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    @Column(
            name = "senha",
            nullable = false
    )
    private String senha;

    @ManyToOne
    @JoinColumn(name ="PERFIL_ID")
    private PerfilEntity perfil;

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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilEntity getPerfil() {
        return this.perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
