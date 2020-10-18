package br.fatec.app.modules.v1.fornecedor;

import br.fatec.app.modules.v1.fornecedor.entity.FornecedorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;


    @Autowired
    public FornecedorService(
            FornecedorRepository fornecedorRepository
    ) {
        this.fornecedorRepository = fornecedorRepository;
    }


    public FornecedorEntity cadastrarFornecedor(FornecedorEntity fornecedor) {
        return this.fornecedorRepository.save(fornecedor);
    }


    public FornecedorEntity alterarFornecedor(FornecedorEntity fornecedor) {
        return this.fornecedorRepository.save(fornecedor);
    }


    public FornecedorEntity buscarFornecedor(long idFornecedor) {
        Optional<FornecedorEntity> fornecedor = this.fornecedorRepository.findById(idFornecedor);
        return fornecedor.orElse(null);
    }


    public List<FornecedorEntity> listarTodosFornecedores() {
        return this.fornecedorRepository.findAll();
    }


    public void desativarFornecedor(long idFornecedor) {
        Optional<FornecedorEntity> fornecedorEntity = this.fornecedorRepository.findById(idFornecedor);

        if (fornecedorEntity.isPresent()) {
            FornecedorEntity fornecedor = fornecedorEntity.get();
            fornecedor.setAtivo(false);
            this.fornecedorRepository.save(fornecedor);
        }
    }

}
