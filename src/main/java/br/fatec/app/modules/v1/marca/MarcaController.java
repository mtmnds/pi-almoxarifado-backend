package br.fatec.app.modules.v1.marca;


import br.fatec.app.modules.v1.marca.entity.MarcaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/marca")
public class MarcaController {

    private MarcaService marcaService;


    @Autowired
    public MarcaController(
            MarcaService marcaService
    ) {
        this.marcaService = marcaService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<MarcaEntity> cadastrarMarca(@RequestBody MarcaEntity marca) {
        try {
            MarcaEntity resposta = this.marcaService.cadastrarMarca(marca);
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
    public ResponseEntity<MarcaEntity> alterarMarca(@RequestBody MarcaEntity marca) {
        try {
            MarcaEntity resposta = this.marcaService.alterarMarca(marca);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idMarca}",
            produces = "application/json"
    )
    public ResponseEntity<MarcaEntity> buscarMarca(@PathVariable("idMarca") long idMarca) {
        try {
            MarcaEntity resposta = this.marcaService.buscarMarca(idMarca);
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
    public ResponseEntity<List<MarcaEntity>> listarTodasMarcas() {
        try {
            List<MarcaEntity> resposta = this.marcaService.listarTodasMarcas();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idMarca}",
            produces = "application/json"
    )
    public ResponseEntity<MarcaEntity> desativarMarca(@PathVariable("idMarca") long idMarca) {
        try {
            this.marcaService.desativarMarca(idMarca);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


}
