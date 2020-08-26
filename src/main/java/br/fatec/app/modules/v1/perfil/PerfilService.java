package br.fatec.app.modules.v1.perfil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerfilService {

    private PerfilRepository perfilRepository;


    @Autowired
    public PerfilService(
            PerfilRepository perfilRepository
    ) {
        this.perfilRepository = perfilRepository;
    }

}
