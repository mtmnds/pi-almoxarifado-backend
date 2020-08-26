package br.fatec.app.modules.v1.inventario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/inventario")
public class InventarioController {

    private InventarioService inventarioService;


    @Autowired
    public InventarioController(
            InventarioService inventarioService
    ) {
        this.inventarioService = inventarioService;
    }

}
