package br.fatec.app.modules.v1.tela;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/menu")
public class TelaController {

    private TelaService telaService;


    @Autowired
    public TelaController(
            TelaService telaService
    ) {
        this.telaService = telaService;
    }

}
