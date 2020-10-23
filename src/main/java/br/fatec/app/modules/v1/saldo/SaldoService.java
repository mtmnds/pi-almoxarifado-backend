package br.fatec.app.modules.v1.saldo;


import br.fatec.app.modules.v1.localestoque.LocalEstoqueRepository;
import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import br.fatec.app.modules.v1.material.MaterialRepository;
import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.saldo.entity.SaldoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        Optional<SaldoEntity> saldoAtualOp = this.saldoRepository.findByMaterialAndLocalEstoque(
                material,
                localEstoque
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
        Optional<SaldoEntity> saldoOp = this.saldoRepository.findByMaterialAndLocalEstoque(
                material,
                localEstoque
        );

        return saldoOp.orElse(null);
    }


    public void atualizarSaldo(SaldoEntity saldoEntity) {
        this.saldoRepository.save(saldoEntity);
    }

}
