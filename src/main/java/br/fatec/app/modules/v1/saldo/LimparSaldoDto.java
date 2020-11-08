package br.fatec.app.modules.v1.saldo;

import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import br.fatec.app.modules.v1.material.entity.MaterialEntity;

public class LimparSaldoDto {

    private LocalEstoqueEntity localEstoque;

    private MaterialEntity material;

    public LocalEstoqueEntity getLocalEstoque() {
        return localEstoque;
    }

    public void setLocalEstoque(LocalEstoqueEntity localEstoque) {
        this.localEstoque = localEstoque;
    }

    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

}
