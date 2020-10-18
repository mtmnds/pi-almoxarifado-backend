package br.fatec.app.modules.v1.localestoque;

import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class LocalEstoqueService {

    private LocalEstoqueRepository localEstoqueRepository;


    @Autowired
    public LocalEstoqueService(
            LocalEstoqueRepository localEstoqueRepository
    ) {
        this.localEstoqueRepository = localEstoqueRepository;
    }


    public LocalEstoqueEntity cadastrarLocalEstoque(LocalEstoqueEntity localEstoque) {
        return this.localEstoqueRepository.save(localEstoque);
    }


    public LocalEstoqueEntity alterarLocalEstoque(LocalEstoqueEntity localEstoque) {
        return this.localEstoqueRepository.save(localEstoque);
    }


    public LocalEstoqueEntity buscarLocalEstoque(long idLocalEstoque) {
        Optional<LocalEstoqueEntity> localEstoque = this.localEstoqueRepository.findById(idLocalEstoque);
        return localEstoque.orElse(null);
    }


    public List<LocalEstoqueEntity> listarTodosLocaisEstoque() {
        return this.localEstoqueRepository.findAll();
    }


    public void desativarLocalEstoque(long idLocalEstoque) {
        Optional<LocalEstoqueEntity> localEstoqueEntity = this.localEstoqueRepository.findById(idLocalEstoque);

        if (localEstoqueEntity.isPresent()) {
            LocalEstoqueEntity localEstoque = localEstoqueEntity.get();
            localEstoque.setAtivo(false);
            this.localEstoqueRepository.save(localEstoque);
        }
    }

}
