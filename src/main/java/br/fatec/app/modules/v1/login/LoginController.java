package br.fatec.app.modules.v1.login;


import br.fatec.app.modules.v1.login.dto.LoginDto;
import br.fatec.app.modules.v1.requisicao.entity.RequisicaoEntity;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    private LoginService loginService;


    @Autowired
    public LoginController(
            LoginService loginService
    ) {
        this.loginService = loginService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<UsuarioEntity> autenticar(@RequestBody LoginDto loginDto) {
        try {
            UsuarioEntity resposta = this.loginService.autenticar(loginDto);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

}
