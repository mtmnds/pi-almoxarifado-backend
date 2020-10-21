package br.fatec.app.modules.v1.saldo;


import br.fatec.app.modules.v1.localestoque.LocalEstoqueRepository;
import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import br.fatec.app.modules.v1.material.MaterialRepository;
import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.saldo.entity.SaldoEntity;
import org.springframework.beans.factory.annotation.Autowired;
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


    public void incrementarSaldo(long idMaterial, long idLocalEstoque, long quantidade) {
        Optional<SaldoEntity> saldoAtualOp = this.saldoRepository.findByIdMaterialAndIdLocalEstoque(
                idMaterial,
                idLocalEstoque
        );

        if (saldoAtualOp.isPresent()) {
            SaldoEntity saldoAtual = saldoAtualOp.get();
            saldoAtual.setQuantidade(saldoAtual.getQuantidade() + quantidade);
            this.saldoRepository.save(saldoAtual);
        }
        else {
            Optional<MaterialEntity> materialOp = this.materialRepository.findById(idMaterial);
            Optional<LocalEstoqueEntity> localEstoqueOp = this.localEstoqueRepository.findById(idLocalEstoque);

            if (materialOp.isPresent() && localEstoqueOp.isPresent()) {
                MaterialEntity materialEntity = materialOp.get();
                LocalEstoqueEntity localEstoqueEntity = localEstoqueOp.get();

                SaldoEntity saldoEntity = new SaldoEntity();
                saldoEntity.setAtivo(true);
                saldoEntity.setMaterial(materialEntity);
                saldoEntity.setLocalEstoque(localEstoqueEntity);
                saldoEntity.setQuantidade(quantidade);
                this.saldoRepository.save(saldoEntity);
            }
        }
    }

}
