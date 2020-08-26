package br.fatec.app.modules.v1.marca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/marca")
public class MarcaController {

    private MarcaService marcaService;


    @Autowired
    public MarcaController(
            MarcaService marcaService
    ) {
        this.marcaService = marcaService;
    }

}
