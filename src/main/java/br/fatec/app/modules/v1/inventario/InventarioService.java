package br.fatec.app.modules.v1.inventario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventarioService {

    private InventarioRepository inventarioRepository;


    @Autowired
    public InventarioService(
            InventarioRepository inventarioRepository
    ) {
        this.inventarioRepository = inventarioRepository;
    }

}
