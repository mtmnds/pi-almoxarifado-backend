package br.fatec.app.modules.v1.movimentacao;


import br.fatec.app.modules.v1.movimentacao.entity.MovimentacaoEntity;
import br.fatec.app.modules.v1.saldo.SaldoService;
import br.fatec.app.modules.v1.saldo.entity.SaldoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


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

        SaldoEntity saldoDestino = this.saldoService.buscarSaldo(
                movimentacao.getLocalDestino(),
                movimentacao.getMaterial()
        );

        if (saldoOrigem != null && saldoDestino != null) {
            saldoOrigem.setQuantidade(saldoOrigem.getQuantidade() - movimentacao.getQuantidade());

            if (saldoOrigem.getQuantidade() < 0) {
                throw new Exception("A movimentação não pode negativar o saldo da origem.");
            }

            saldoDestino.setQuantidade(saldoOrigem.getQuantidade() + movimentacao.getQuantidade());

            this.saldoService.atualizarSaldo(saldoOrigem);
            this.saldoService.atualizarSaldo(saldoDestino);
            movimentacaoEntity = this.movimentacaoRepository.save(movimentacao);
        }

        return movimentacaoEntity;
    }

}
