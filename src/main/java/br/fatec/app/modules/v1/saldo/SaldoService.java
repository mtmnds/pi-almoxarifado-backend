package br.fatec.app.modules.v1.saldo;


import br.fatec.app.modules.v1.localestoque.LocalEstoqueRepository;
import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import br.fatec.app.modules.v1.material.MaterialRepository;
import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.saldo.entity.SaldoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SaldoService {

    private SaldoRepository saldoRepository;

    private MaterialRepository materialRepository;

    private LocalEstoqueRepository localEstoqueRepository;


    @Autowired
    public SaldoService(
            SaldoRepository saldoRepository,
            MaterialRepository materialRepository,
            LocalEstoqueRepository localEstoqueRepository
    ) {
        this.saldoRepository = saldoRepository;
        this.materialRepository = materialRepository;
        this.localEstoqueRepository = localEstoqueRepository;
    }


    public void incrementarSaldo(MaterialEntity material, LocalEstoqueEntity localEstoque, float quantidade) {
        Optional<SaldoEntity> saldoAtualOp = this.saldoRepository.findByMaterialIdAndLocalEstoqueId(
                material.getId(),
                localEstoque.getId()
        );

        if (saldoAtualOp.isPresent()) {
            SaldoEntity saldoAtual = saldoAtualOp.get();
            saldoAtual.setQuantidade(saldoAtual.getQuantidade() + quantidade);
            this.saldoRepository.save(saldoAtual);

        }
        else {
            SaldoEntity saldoEntity = new SaldoEntity();
            saldoEntity.setAtivo(true);
            saldoEntity.setMaterial(material);
            saldoEntity.setLocalEstoque(localEstoque);
            saldoEntity.setQuantidade(quantidade);
            this.saldoRepository.save(saldoEntity);

        }
    }


    public SaldoEntity buscarSaldo(LocalEstoqueEntity localEstoque, MaterialEntity material) {
        Optional<SaldoEntity> saldoOp = this.saldoRepository.findByMaterialIdAndLocalEstoqueId(
                material.getId(),
                localEstoque.getId()
        );

        return saldoOp.orElse(null);
    }
    
    public List<SaldoEntity> listarTodosSaldoEstoque() {
    	return this.saldoRepository.findAll();
    }


    public void limparSaldo(LocalEstoqueEntity localEstoque, MaterialEntity material) {
        Optional<SaldoEntity> saldoOp = this.saldoRepository.findByMaterialIdAndLocalEstoqueId(
                material.getId(),
                localEstoque.getId()
        );

        if (saldoOp.isPresent()) {
            SaldoEntity saldo = saldoOp.get();
            saldo.setQuantidade(0);
            this.saldoRepository.save(saldo);
        }
    }


    public void atualizarSaldo(SaldoEntity saldoEntity) {
        this.saldoRepository.save(saldoEntity);
    }


    public void cadastrar(SaldoEntity saldoEntity) {
        this.saldoRepository.saveAndFlush(saldoEntity);
    }

}
