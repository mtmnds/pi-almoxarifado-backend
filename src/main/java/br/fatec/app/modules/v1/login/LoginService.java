package br.fatec.app.modules.v1.login;


import br.fatec.app.modules.v1.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private UsuarioService usuarioService;


    @Autowired
    public LoginService(
            UsuarioService usuarioService
    ) {
        this.usuarioService = usuarioService;
    }

}
