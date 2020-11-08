package br.fatec.app.modules.v1.saldo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import br.fatec.app.modules.v1.saldo.entity.SaldoEntity;


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

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/buscarSaldo",
            produces = "application/json"
    )
    public ResponseEntity<SaldoEntity> listarSaldoEstoque(@RequestBody LocalEstoqueEntity localEstoque, @RequestBody MaterialEntity material) {
        try {
            SaldoEntity resposta = this.saldoService.buscarSaldo(localEstoque, material);
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/limparSaldo",
            produces = "application/json",
            consumes = "application/json"
    )
    public ResponseEntity<SaldoEntity> limparSaldo(@RequestBody LimparSaldoDto limparSaldoDto) {
        try {
            this.saldoService.limparSaldo(
                    limparSaldoDto.getLocalEstoque(),
                    limparSaldoDto.getMaterial()
            );
            return ResponseEntity.ok().build();

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
    public ResponseEntity<List<SaldoEntity>> listarTodosSaldoEstoque() {
        try {
            List<SaldoEntity> resposta = this.saldoService.listarTodosSaldoEstoque();
            return ResponseEntity.ok(resposta);

        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


}
