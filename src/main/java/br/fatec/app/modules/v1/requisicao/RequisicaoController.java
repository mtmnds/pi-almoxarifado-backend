package br.fatec.app.modules.v1.requisicao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/requisicao")
public class RequisicaoController {

    private RequisicaoService requisicaoService;


    @Autowired
    public RequisicaoController(
            RequisicaoService requisicaoService
    ) {
        this.requisicaoService = requisicaoService;
    }

}
