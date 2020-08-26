package br.fatec.app.modules.v1.localestoque;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/localestoque")
public class LocalEstoqueController {

    private LocalEstoqueService localEstoqueService;


    @Autowired
    public LocalEstoqueController(
            LocalEstoqueService localEstoqueService
    ) {
        this.localEstoqueService = localEstoqueService;
    }

}
