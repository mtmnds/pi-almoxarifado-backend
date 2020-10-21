package br.fatec.app.modules.v1.requisicao;


import br.fatec.app.modules.v1.requisicao.entity.RequisicaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/requisicao")
public class RequisicaoController {

    private RequisicaoService requisicaoService;


    @Autowired
    public RequisicaoController(
            RequisicaoService requisicaoService
    ) {
        this.requisicaoService = requisicaoService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<RequisicaoEntity> criarRequisicao(@RequestBody RequisicaoEntity requisicao) {
        try {
            RequisicaoEntity resposta = this.requisicaoService.criarRequisicao(requisicao);
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
    public ResponseEntity<RequisicaoEntity> alterarRequisicao(@RequestBody RequisicaoEntity requisicao) {
        try {
            RequisicaoEntity resposta = this.requisicaoService.alterarRequisicao(requisicao);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    /*@RequestMapping(
            method = RequestMethod.GET,
            value = "/{idUsuario}",
            produces = "application/json"
    )
    public ResponseEntity<UsuarioEntity> buscarUsuario(@PathVariable("idUsuario") long idUsuario) {
        try {
            UsuarioEntity resposta = this.usuarioService.buscarUsuario(idUsuario);
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
    public ResponseEntity<List<UsuarioEntity>> listarTodosUsuarios() {
        try {
            List<UsuarioEntity> resposta = this.usuarioService.listarTodosUsuarios();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idUsuario}",
            produces = "application/json"
    )
    public ResponseEntity<UsuarioEntity> desativarUsuario(@PathVariable("idUsuario") long idUsuario) {
        try {
            this.usuarioService.desativarUsuario(idUsuario);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }*/

}
