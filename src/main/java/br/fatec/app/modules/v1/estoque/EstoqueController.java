package br.fatec.app.modules.v1.estoque;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/estoque")
public class EstoqueController {

    private EstoqueService estoqueService;


    @Autowired
    public EstoqueController(
            EstoqueService estoqueService
    ) {
        this.estoqueService = estoqueService;
    }

}
