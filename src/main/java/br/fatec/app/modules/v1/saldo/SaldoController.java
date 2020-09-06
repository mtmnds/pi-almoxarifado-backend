package br.fatec.app.modules.v1.saldo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/estoque")
public class SaldoController {

    private SaldoService saldoService;


    @Autowired
    public SaldoController(
            SaldoService saldoService
    ) {
        this.saldoService = saldoService;
    }

}
