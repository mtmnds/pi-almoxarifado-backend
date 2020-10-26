package br.fatec.app.modules.v1.inventario;


import br.fatec.app.modules.v1.inventario.entity.InventarioEntity;
import br.fatec.app.modules.v1.inventario.dto.AprovarInventarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<InventarioEntity> criarInventario(@RequestBody InventarioEntity inventario) {
        try {
            InventarioEntity resposta = this.inventarioService.criarInventario(inventario);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<InventarioEntity> alterarInventario(@RequestBody InventarioEntity inventario) {
        try {
            InventarioEntity resposta = this.inventarioService.alterarInventario(inventario);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idInventario}",
            produces = "application/json"
    )
    public ResponseEntity<InventarioEntity> buscarInventario(@PathVariable("idInventario") long idInventario) {
        try {
            InventarioEntity resposta = this.inventarioService.buscarInventario(idInventario);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = {"", "/"},
            produces = "application/json"
    )
    public ResponseEntity<List<InventarioEntity>> listarTodosInventarios() {
        try {
            List<InventarioEntity> resposta = this.inventarioService.listarTodosInventarios();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idInventario}",
            produces = "application/json"
    )
    public ResponseEntity<InventarioEntity> cancelarInventario(@PathVariable("idInventario") long idInventario) {
        try {
            this.inventarioService.cancelarInventario(idInventario);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/aprovacao",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<InventarioEntity> aprovarInventario(@RequestBody AprovarInventarioDTO aprovarInventarioDTO) {
        try {
            this.inventarioService.aprovarInventario(
                    aprovarInventarioDTO.getIdInventario()
            );

            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

}
