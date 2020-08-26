package br.fatec.app.modules.v1.modelo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/modelo")
public class ModeloController {

    private ModeloService modeloService;


    @Autowired
    public ModeloController(
            ModeloService modeloService
    ) {
        this.modeloService = modeloService;
    }

}
