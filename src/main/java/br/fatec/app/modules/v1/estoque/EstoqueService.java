package br.fatec.app.modules.v1.estoque;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstoqueService {

    private EstoqueRepository estoqueRepository;


    @Autowired
    public EstoqueService(
            EstoqueRepository estoqueRepository
    ) {
        this.estoqueRepository = estoqueRepository;
    }

}
