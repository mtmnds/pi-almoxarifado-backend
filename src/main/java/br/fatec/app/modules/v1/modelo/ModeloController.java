package br.fatec.app.modules.v1.modelo;

import br.fatec.app.modules.v1.modelo.entity.ModeloEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/modelo")
public class ModeloController {

    private ModeloService modeloService;


    @Autowired
    public ModeloController(
            ModeloService modeloService
    ) {
        this.modeloService = modeloService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<ModeloEntity> cadastrarModelo(@RequestBody ModeloEntity modelo) {
        try {
            ModeloEntity resposta = this.modeloService.cadastrarModelo(modelo);
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
    public ResponseEntity<ModeloEntity> alterarModelo(@RequestBody ModeloEntity modelo) {
        try {
            ModeloEntity resposta = this.modeloService.alterarModelo(modelo);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idModelo}",
            produces = "application/json"
    )
    public ResponseEntity<ModeloEntity> buscarModelo(@PathVariable("idModelo") long idModelo) {
        try {
            ModeloEntity resposta = this.modeloService.buscarModelo(idModelo);
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
    public ResponseEntity<List<ModeloEntity>> listarTodosModelos() {
        try {
            List<ModeloEntity> resposta = this.modeloService.listarTodosModelos();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idModelo}",
            produces = "application/json"
    )
    public ResponseEntity<ModeloEntity> desativarModelo(@PathVariable("idModelo") long idModelo) {
        try {
            this.modeloService.desativarModelo(idModelo);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
