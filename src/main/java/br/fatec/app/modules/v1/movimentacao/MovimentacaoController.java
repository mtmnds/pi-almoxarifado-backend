package br.fatec.app.modules.v1.movimentacao;


import br.fatec.app.modules.v1.movimentacao.entity.MovimentacaoEntity;
import br.fatec.app.modules.v1.requisicao.entity.RequisicaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<MovimentacaoEntity> movimentarSaldo(@RequestBody MovimentacaoEntity movimentacao) {
        try {
            MovimentacaoEntity resposta = this.movimentacaoService.movimentarSaldo(movimentacao);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

}
