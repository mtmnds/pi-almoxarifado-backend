package br.fatec.app.modules.v1.localestoque;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LocalEstoqueService {

    private LocalEstoqueRepository localEstoqueRepository;


    @Autowired
    public LocalEstoqueService(
            LocalEstoqueRepository localEstoqueRepository
    ) {
        this.localEstoqueRepository = localEstoqueRepository;
    }

}
