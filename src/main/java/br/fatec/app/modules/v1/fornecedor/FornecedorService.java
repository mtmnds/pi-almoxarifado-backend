package br.fatec.app.modules.v1.fornecedor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;


    @Autowired
    public FornecedorService(
            FornecedorRepository fornecedorRepository
    ) {
        this.fornecedorRepository = fornecedorRepository;
    }

}
