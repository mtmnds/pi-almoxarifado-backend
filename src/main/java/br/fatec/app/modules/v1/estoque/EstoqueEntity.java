package br.fatec.app.modules.v1.estoque;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "estoque")
public class EstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
