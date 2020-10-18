package br.fatec.app.modules.v1.perfil;

import br.fatec.app.modules.v1.perfil.entity.PerfilEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/perfil")
public class PerfilController {

    private PerfilService perfilService;


    @Autowired
    public PerfilController(
            PerfilService perfilService
    ) {
        this.perfilService = perfilService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<PerfilEntity> cadastrarPerfil(@RequestBody PerfilEntity perfil) {
        try {
            PerfilEntity resposta = this.perfilService.cadastrarPerfil(perfil);
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
    public ResponseEntity<PerfilEntity> alterarPerfil(@RequestBody PerfilEntity perfil) {
        try {
            PerfilEntity resposta = this.perfilService.alterarPerfil(perfil);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idPerfil}",
            produces = "application/json"
    )
    public ResponseEntity<PerfilEntity> buscarPerfil(@PathVariable("idPerfil") long idPerfil) {
        try {
            PerfilEntity resposta = this.perfilService.buscarPerfil(idPerfil);
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
    public ResponseEntity<List<PerfilEntity>> listarTodosPerfis() {
        try {
            List<PerfilEntity> resposta = this.perfilService.listarTodosPerfis();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idPerfil}",
            produces = "application/json"
    )
    public ResponseEntity<PerfilEntity> desativarPerfil(@PathVariable("idPerfil") long idPerfil) {
        try {
            this.perfilService.desativarPerfil(idPerfil);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
