package br.fatec.app.modules.v1.perfil;

import br.fatec.app.modules.v1.perfil.entity.PerfilEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class PerfilService {

    private PerfilRepository perfilRepository;


    @Autowired
    public PerfilService(
            PerfilRepository perfilRepository
    ) {
        this.perfilRepository = perfilRepository;
    }


    public PerfilEntity cadastrarPerfil(PerfilEntity perfil) {
        return this.perfilRepository.save(perfil);
    }


    public PerfilEntity alterarPerfil(PerfilEntity perfil) {
        return this.perfilRepository.save(perfil);
    }


    public PerfilEntity buscarPerfil(long idPerfil) {
        Optional<PerfilEntity> perfil = this.perfilRepository.findById(idPerfil);
        return perfil.orElse(null);
    }


    public List<PerfilEntity> listarTodosPerfis() {
        return this.perfilRepository.findAll();
    }


    public void desativarPerfil(long idPerfil) {
        Optional<PerfilEntity> perfilEntity = this.perfilRepository.findById(idPerfil);

        if (perfilEntity.isPresent()) {
            PerfilEntity perfil = perfilEntity.get();
            perfil.setAtivo(false);
            this.perfilRepository.save(perfil);
        }
    }

}
