package br.fatec.app.modules.v1.acesso.entity;


import br.fatec.app.modules.v1.menu.entity.MenuEntity;
import br.fatec.app.modules.v1.perfil.entity.PerfilEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "acesso")
public class AcessoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private PerfilEntity perfil;

    @ManyToOne
    private MenuEntity menu;

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

    public PerfilEntity getPerfil() {
        return this.perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public MenuEntity getMenu() {
        return this.menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
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
