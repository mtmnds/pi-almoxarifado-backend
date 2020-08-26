package br.fatec.app.modules.v1.recebimento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
