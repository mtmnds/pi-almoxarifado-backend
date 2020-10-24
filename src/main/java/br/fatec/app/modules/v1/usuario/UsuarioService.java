package br.fatec.app.modules.v1.usuario;

import br.fatec.app.modules.v1.login.dto.LoginDto;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioService(
            UsuarioRepository usuarioRepository
    ) {
        this.usuarioRepository = usuarioRepository;
    }


    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) {
        return this.usuarioRepository.save(usuario);
    }


    public UsuarioEntity alterarUsuario(UsuarioEntity usuario) {
        return this.usuarioRepository.save(usuario);
    }


    public UsuarioEntity buscarUsuario(long idUsuario) {
        Optional<UsuarioEntity> usuario = this.usuarioRepository.findById(idUsuario);
        return usuario.orElse(null);
    }


    public UsuarioEntity buscarUsuario(LoginDto loginDto) {
        Optional<UsuarioEntity> usuario = this.usuarioRepository.findByEmailAndSenha(
                loginDto.getEmail(),
                loginDto.getSenha()
        );

        return usuario.orElse(null);
    }


    public List<UsuarioEntity> listarTodosUsuarios() {
        return this.usuarioRepository.findAll();
    }


    public void desativarUsuario(long idUsuario) {
        Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findById(idUsuario);

        if (usuarioEntity.isPresent()) {
            UsuarioEntity usuario = usuarioEntity.get();
            usuario.setAtivo(false);
            this.usuarioRepository.save(usuario);
        }
    }

}
