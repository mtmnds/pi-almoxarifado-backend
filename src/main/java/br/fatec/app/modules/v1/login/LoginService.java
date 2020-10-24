package br.fatec.app.modules.v1.login;


import br.fatec.app.modules.v1.login.dto.LoginDto;
import br.fatec.app.modules.v1.usuario.UsuarioService;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class LoginService {

    private UsuarioService usuarioService;


    @Autowired
    public LoginService(
            UsuarioService usuarioService
    ) {
        this.usuarioService = usuarioService;
    }


    public UsuarioEntity autenticar(LoginDto loginDto) {
        UsuarioEntity usuario = this.usuarioService.buscarUsuario(loginDto);
        return usuario;
    }

}
