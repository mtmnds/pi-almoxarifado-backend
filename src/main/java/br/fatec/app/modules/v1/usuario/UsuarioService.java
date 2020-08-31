package br.fatec.app.modules.v1.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioService(
            UsuarioRepository usuarioRepository
    ) {
        this.usuarioRepository = usuarioRepository;
    }

}