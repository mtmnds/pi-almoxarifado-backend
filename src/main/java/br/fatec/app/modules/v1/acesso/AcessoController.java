package br.fatec.app.modules.v1.acesso;

import br.fatec.app.modules.v1.acesso.entity.AcessoEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/acesso")
public class AcessoController {

    private AcessoService acessoService;


    @Autowired
    public AcessoController(
            AcessoService acessoService
    ) {
        this.acessoService = acessoService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<AcessoEntity> cadastrarAcesso(@RequestBody AcessoEntity acesso) {
        try {
            AcessoEntity resposta = this.acessoService.cadastrarAcesso(acesso);
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
    public ResponseEntity<AcessoEntity> alterarAcesso(@RequestBody AcessoEntity acesso) {
        try {
            AcessoEntity resposta = this.acessoService.alterarAcesso(acesso);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idAcesso}",
            produces = "application/json"
    )
    public ResponseEntity<AcessoEntity> buscarAcesso(@PathVariable("idAcesso") long idAcesso) {
        try {
            AcessoEntity resposta = this.acessoService.buscarAcesso(idAcesso);
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
    public ResponseEntity<List<AcessoEntity>> listarTodosAcessos() {
        try {
            List<AcessoEntity> resposta = this.acessoService.listarTodosAcessos();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idAcesso}",
            produces = "application/json"
    )
    public ResponseEntity<AcessoEntity> desativarAcesso(@PathVariable("idAcesso") long idAcesso) {
        try {
            this.acessoService.desativarAcesso(idAcesso);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
