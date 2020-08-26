package br.fatec.app.modules.v1.movimentacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/movimentacao")
public class MovimentacaoController {

    private MovimentacaoService movimentacaoService;


    @Autowired
    public MovimentacaoController(
            MovimentacaoService movimentacaoService
    ) {
        this.movimentacaoService = movimentacaoService;
    }

}
