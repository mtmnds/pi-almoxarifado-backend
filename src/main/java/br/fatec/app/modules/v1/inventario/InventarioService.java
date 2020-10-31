package br.fatec.app.modules.v1.inventario;


import br.fatec.app.modules.v1.inventario.entity.InventarioEntity;
import br.fatec.app.modules.v1.inventario.entity.ItemInventarioEntity;
import br.fatec.app.modules.v1.inventario.entity.StatusInventarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class InventarioService {

    private InventarioRepository inventarioRepository;

    private ItemInventarioRepository itemInventarioRepository;

    private StatusInventarioRepository statusInventarioRepository;

    @Autowired
    public InventarioService(
            InventarioRepository inventarioRepository,
            ItemInventarioRepository itemInventarioRepository,
            StatusInventarioRepository statusInventarioRepository
    ) {
        this.inventarioRepository = inventarioRepository;
        this.itemInventarioRepository = itemInventarioRepository;
        this.statusInventarioRepository = statusInventarioRepository;
    }

    public InventarioEntity criarInventario(InventarioEntity inventario) {
        return this.inventarioRepository.save(inventario);
    }

    public InventarioEntity alterarInventario(InventarioEntity inventario) {
        return this.inventarioRepository.save(inventario);
    }


    public InventarioEntity buscarInventario(long idInventario) {
        Optional<InventarioEntity> inventarioEntity = this.inventarioRepository.findById(idInventario);
        return inventarioEntity.orElse(null);
    }


    public List<InventarioEntity> listarTodosInventarios() {
        return this.inventarioRepository.findAll();
    }


    @Transactional
    public void cancelarInventario(long idInventario) {
        Optional<InventarioEntity> inventarioEntity = this.inventarioRepository.findById(idInventario);

        if (inventarioEntity.isPresent()) {
            InventarioEntity inventario = inventarioEntity.get();
            inventario.setAtivo(false);
            this.inventarioRepository.save(inventario);

            for (ItemInventarioEntity itemInventario : inventario.getItens()) {
                itemInventario.setAtivo(false);
                this.itemInventarioRepository.save(itemInventario);
            }
        }
    }


    @Transactional
    public void aprovarInventario(long idInventario) {
        Optional<InventarioEntity> inventarioOp = this.inventarioRepository.findById(idInventario);
        Optional<StatusInventarioEntity> statusInventarioOp = this.statusInventarioRepository.findById(2L);

        if (inventarioOp.isPresent() && statusInventarioOp.isPresent()) {
            StatusInventarioEntity statusInventarioEntity = statusInventarioOp.get();

            InventarioEntity inventario = inventarioOp.get();
            inventario.setStatusInventario(statusInventarioEntity);
            this.inventarioRepository.save(inventario);
        }
    }
}
