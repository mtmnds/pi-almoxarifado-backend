package br.fatec.app.modules.v1.recebimento.entity;

import br.fatec.app.modules.v1.fornecedor.entity.FornecedorEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
    private FornecedorEntity fornecedor;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(
            name = "idNotaFiscal"
    )
    private List<ItemNotaFiscalEntity> itens;

    @Column(
            name = "ativo",
            nullable = false
    )
    private boolean ativo;
    
    @Column(
    		name = "dataRecebimento",
    		nullable = false
    )
    private Date dataRecebimento;
    
    @Transient
    private UsuarioEntity usuario;


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

    public FornecedorEntity getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(FornecedorEntity fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
	public List<ItemNotaFiscalEntity> getItens() {
		return itens;
	}

	public void setItens(List<ItemNotaFiscalEntity> itens) {
		this.itens = itens;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
}
