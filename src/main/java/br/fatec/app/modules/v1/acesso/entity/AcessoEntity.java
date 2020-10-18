package br.fatec.app.modules.v1.acesso.entity;


import br.fatec.app.modules.v1.tela.entity.TelaEntity;
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
    @JoinColumn(name ="PERFIL_ID")
    private PerfilEntity perfil;

    @ManyToOne
    @JoinColumn(name ="TELA_ID")
    private TelaEntity tela;

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

    public PerfilEntity getPerfil() {
        return this.perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public TelaEntity getTela() {
        return this.tela;
    }

    public void setTela(TelaEntity tela) {
        this.tela = tela;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
