package br.fatec.app.modules.v1.fornecedor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/fornecedor")
public class FornecedorController {

    private FornecedorService fornecedorService;


    @Autowired
    public FornecedorController(
            FornecedorService fornecedorService
    ) {
        this.fornecedorService = fornecedorService;
    }

}
