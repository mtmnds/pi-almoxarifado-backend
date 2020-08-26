package br.fatec.app.modules.v1.acesso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/acesso")
public class AcessoController {

    private AcessoService acessoService;


    @Autowired
    public AcessoController(
            AcessoService acessoService
    ) {
        this.acessoService = acessoService;
    }

}
