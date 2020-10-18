package br.fatec.app.modules.v1.localestoque;

import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/localEstoque")
public class LocalEstoqueController {

    private LocalEstoqueService localEstoqueService;


    @Autowired
    public LocalEstoqueController(
            LocalEstoqueService localEstoqueService
    ) {
        this.localEstoqueService = localEstoqueService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<LocalEstoqueEntity> cadastrarLocalEstoque(@RequestBody LocalEstoqueEntity localEstoque) {
        try {
            LocalEstoqueEntity resposta = this.localEstoqueService.cadastrarLocalEstoque(localEstoque);
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
    public ResponseEntity<LocalEstoqueEntity> alterarLocalEstoque(@RequestBody LocalEstoqueEntity localEstoque) {
        try {
            LocalEstoqueEntity resposta = this.localEstoqueService.alterarLocalEstoque(localEstoque);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idLocalEstoque}",
            produces = "application/json"
    )
    public ResponseEntity<LocalEstoqueEntity> buscarLocalEstoque(@PathVariable("idLocalEstoque") long idLocalEstoque) {
        try {
            LocalEstoqueEntity resposta = this.localEstoqueService.buscarLocalEstoque(idLocalEstoque);
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
    public ResponseEntity<List<LocalEstoqueEntity>> listarTodosLocaisEstoque() {
        try {
            List<LocalEstoqueEntity> resposta = this.localEstoqueService.listarTodosLocaisEstoque();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idLocalEstoque}",
            produces = "application/json"
    )
    public ResponseEntity<LocalEstoqueEntity> desativarLocalEstoque(@PathVariable("idLocalEstoque") long idLocalEstoque) {
        try {
            this.localEstoqueService.desativarLocalEstoque(idLocalEstoque);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
