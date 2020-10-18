package br.fatec.app.modules.v1.fornecedor;

import br.fatec.app.modules.v1.fornecedor.entity.FornecedorEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/fornecedor")
public class FornecedorController {

    private FornecedorService fornecedorService;


    @Autowired
    public FornecedorController(
            FornecedorService fornecedorService
    ) {
        this.fornecedorService = fornecedorService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<FornecedorEntity> cadastrarFornecedor(@RequestBody FornecedorEntity fornecedor) {
        try {
            FornecedorEntity resposta = this.fornecedorService.cadastrarFornecedor(fornecedor);
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
    public ResponseEntity<FornecedorEntity> alterarFornecedor(@RequestBody FornecedorEntity fornecedor) {
        try {
            FornecedorEntity resposta = this.fornecedorService.alterarFornecedor(fornecedor);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idFornecedor}",
            produces = "application/json"
    )
    public ResponseEntity<FornecedorEntity> buscarFornecedor(@PathVariable("idFornecedor") long idFornecedor) {
        try {
            FornecedorEntity resposta = this.fornecedorService.buscarFornecedor(idFornecedor);
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
    public ResponseEntity<List<FornecedorEntity>> listarTodosFornecedores() {
        try {
            List<FornecedorEntity> resposta = this.fornecedorService.listarTodosFornecedores();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idFornecedor}",
            produces = "application/json"
    )
    public ResponseEntity<FornecedorEntity> desativarFornecedor(@PathVariable("idFornecedor") long idFornecedor) {
        try {
            this.fornecedorService.desativarFornecedor(idFornecedor);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
