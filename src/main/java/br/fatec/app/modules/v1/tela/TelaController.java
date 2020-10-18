package br.fatec.app.modules.v1.tela;


import br.fatec.app.modules.v1.tela.entity.TelaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/tela")
public class TelaController {

    private TelaService telaService;


    @Autowired
    public TelaController(
            TelaService telaService
    ) {
        this.telaService = telaService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<TelaEntity> cadastrarTela(@RequestBody TelaEntity tela) {
        try {
            TelaEntity resposta = this.telaService.cadastrarTela(tela);
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
    public ResponseEntity<TelaEntity> alterarTela(@RequestBody TelaEntity tela) {
        try {
            TelaEntity resposta = this.telaService.alterarTela(tela);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idTela}",
            produces = "application/json"
    )
    public ResponseEntity<TelaEntity> buscarTela(@PathVariable("idTela") long idTela) {
        try {
            TelaEntity resposta = this.telaService.buscarTela(idTela);
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
    public ResponseEntity<List<TelaEntity>> listarTodasTelas() {
        try {
            List<TelaEntity> resposta = this.telaService.listarTodasTelas();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idTela}",
            produces = "application/json"
    )
    public ResponseEntity<TelaEntity> desativarTela(@PathVariable("idTela") long idTela) {
        try {
            this.telaService.desativarTela(idTela);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


}
