package br.fatec.app.modules.v1.material;


import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<MaterialEntity> cadastrarMaterial(@RequestBody MaterialEntity material) {
        try {
            MaterialEntity resposta = this.materialService.cadastrarMaterial(material);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<MaterialEntity> alterarMaterial(@RequestBody MaterialEntity material) {
        try {
            MaterialEntity resposta = this.materialService.alterarMaterial(material);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idMaterial}",
            produces = "application/json"
    )
    public ResponseEntity<MaterialEntity> buscarMaterial(@PathVariable("idMaterial") long idMaterial) {
        try {
            MaterialEntity resposta = this.materialService.buscarMaterial(idMaterial);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = {"", "/"},
            produces = "application/json"
    )
    public ResponseEntity<List<MaterialEntity>> listarTodosMateriais() {
        try {
            List<MaterialEntity> resposta = this.materialService.listarTodosMateriais();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idMaterial}",
            produces = "application/json"
    )
    public ResponseEntity<MaterialEntity> desativarMaterial(@PathVariable("idMaterial") long idMaterial) {
        try {
            this.materialService.desativarMaterial(idMaterial);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


}
