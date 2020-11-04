package br.fatec.app.modules.v1.recebimento;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.app.modules.v1.recebimento.entity.NotaFiscalEntity;


@RestController
@RequestMapping("api/v1/recebimento")
public class RecebimentoController {

    private RecebimentoService recebimentoService;


    @Autowired
    public RecebimentoController(
            RecebimentoService recebimentoService
    ) {
        this.recebimentoService = recebimentoService;
    }
    
    @RequestMapping(
            method = RequestMethod.GET,
            value = {"", "/"},
            produces = "application/json"
    )
    public ResponseEntity<List<NotaFiscalEntity>> listarNotasFiscais() {
        try {
            List<NotaFiscalEntity> resposta = this.recebimentoService.listarNotasFiscais();
            return ResponseEntity.ok(resposta);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
