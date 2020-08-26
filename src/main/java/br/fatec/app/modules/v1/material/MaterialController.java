package br.fatec.app.modules.v1.material;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/material")
public class MaterialController {

    private MaterialService materialService;


    @Autowired
    public MaterialController(
            MaterialService materialService
    ) {
        this.materialService = materialService;
    }

}
