package br.fatec.app.modules.v1.usuario;

import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;


    @Autowired
    public UsuarioController(
            UsuarioService usuarioService
    ) {
        this.usuarioService = usuarioService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<UsuarioEntity> cadastrarUsuario(@RequestBody UsuarioEntity usuario) {
        try {
            UsuarioEntity resposta = this.usuarioService.cadastrarUsuario(usuario);
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
    public ResponseEntity<UsuarioEntity> alterarUsuario(@RequestBody UsuarioEntity usuario) {
        try {
            UsuarioEntity resposta = this.usuarioService.alterarUsuario(usuario);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
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
    }
}
