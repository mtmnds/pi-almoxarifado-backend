package br.fatec.app.modules.v1.requisicao;


import br.fatec.app.modules.v1.requisicao.dto.AprovarRequisicaoDTO;
import br.fatec.app.modules.v1.requisicao.entity.RequisicaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/requisicao")
public class RequisicaoController {

    private RequisicaoService requisicaoService;


    @Autowired
    public RequisicaoController(
            RequisicaoService requisicaoService
    ) {
        this.requisicaoService = requisicaoService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = {"", "/"},
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<RequisicaoEntity> criarRequisicao(@RequestBody RequisicaoEntity requisicao) {
        try {
            RequisicaoEntity resposta = this.requisicaoService.criarRequisicao(requisicao);
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
    public ResponseEntity<RequisicaoEntity> alterarRequisicao(@RequestBody RequisicaoEntity requisicao) {
        try {
            RequisicaoEntity resposta = this.requisicaoService.alterarRequisicao(requisicao);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idRequisicao}",
            produces = "application/json"
    )
    public ResponseEntity<RequisicaoEntity> buscarRequisicao(@PathVariable("idRequisicao") long idRequisicao) {
        try {
            RequisicaoEntity resposta = this.requisicaoService.buscarRequisicao(idRequisicao);
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
    public ResponseEntity<List<RequisicaoEntity>> listarTodasRequisicoes() {
        try {
            List<RequisicaoEntity> resposta = this.requisicaoService.listarTodasRequisicoes();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{idRequisicao}",
            produces = "application/json"
    )
    public ResponseEntity<RequisicaoEntity> cancelarRequisicao(@PathVariable("idRequisicao") long idRequisicao) {
        try {
            this.requisicaoService.cancelarRequisicao(idRequisicao);
            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/aprovacao",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<RequisicaoEntity> aprovarRequisicao(@RequestBody AprovarRequisicaoDTO aprovarRequisicaoDTO) {
        try {
            this.requisicaoService.aprovarRequisicao(
                    aprovarRequisicaoDTO.getIdRequisicao(),
                    aprovarRequisicaoDTO.getIdUsuarioAtendente()
            );

            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/reprovacao",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<RequisicaoEntity> reprovarRequisicao(@RequestBody AprovarRequisicaoDTO aprovarRequisicaoDTO) {
        try {
            this.requisicaoService.reprovarRequisicao(
                    aprovarRequisicaoDTO.getIdRequisicao(),
                    aprovarRequisicaoDTO.getIdUsuarioAtendente()
            );

            return ResponseEntity.ok().build();

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


}
