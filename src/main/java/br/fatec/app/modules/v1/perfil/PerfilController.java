package br.fatec.app.modules.v1.perfil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
