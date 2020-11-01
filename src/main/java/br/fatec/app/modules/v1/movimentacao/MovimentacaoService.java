package br.fatec.app.modules.v1.movimentacao;


import br.fatec.app.modules.v1.movimentacao.entity.MovimentacaoEntity;
import br.fatec.app.modules.v1.saldo.SaldoService;
import br.fatec.app.modules.v1.saldo.entity.SaldoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;
import java.util.Date;


@Service
public class MovimentacaoService {

    private MovimentacaoRepository movimentacaoRepository;

    private SaldoService saldoService;


    @Autowired
    public MovimentacaoService(
            MovimentacaoRepository movimentacaoRepository,
            SaldoService saldoService
    ) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.saldoService = saldoService;
    }


    @Transactional
    public MovimentacaoEntity movimentarSaldo(MovimentacaoEntity movimentacao) throws Exception {
        MovimentacaoEntity movimentacaoEntity = null;

        SaldoEntity saldoOrigem = this.saldoService.buscarSaldo(
                movimentacao.getLocalOrigem(),
                movimentacao.getMaterial()
        );

        if (saldoOrigem == null) {
            saldoOrigem = new SaldoEntity();
            saldoOrigem.setMaterial(movimentacao.getMaterial());
            saldoOrigem.setLocalEstoque(movimentacao.getLocalOrigem());
            saldoOrigem.setQuantidade(0);
            saldoOrigem.setAtivo(true);
            this.saldoService.cadastrar(saldoOrigem);
        }

        SaldoEntity saldoDestino = this.saldoService.buscarSaldo(
                movimentacao.getLocalDestino(),
                movimentacao.getMaterial()
        );

        if (saldoDestino == null) {
            saldoDestino = new SaldoEntity();
            saldoDestino.setMaterial(movimentacao.getMaterial());
            saldoDestino.setLocalEstoque(movimentacao.getLocalDestino());
            saldoDestino.setQuantidade(0);
            saldoDestino.setAtivo(true);
            this.saldoService.cadastrar(saldoDestino);
        }

        if (saldoOrigem != null && saldoDestino != null) {
            saldoOrigem.setQuantidade(saldoOrigem.getQuantidade() - movimentacao.getQuantidade());

            /*if (saldoOrigem.getQuantidade() < 0) {
                throw new Exception("A movimentação não pode negativar o saldo da origem.");
            }*/

            saldoDestino.setQuantidade(saldoDestino.getQuantidade() + movimentacao.getQuantidade());

            this.saldoService.atualizarSaldo(saldoOrigem);
            this.saldoService.atualizarSaldo(saldoDestino);
            movimentacao.setDataMovimentacao(new Date());
            movimentacaoEntity = this.movimentacaoRepository.save(movimentacao);
        }

        return movimentacaoEntity;
    }
    
    public List<MovimentacaoEntity> listarMovimentacoes() {
    	return this.movimentacaoRepository.findAll();
    }

}
