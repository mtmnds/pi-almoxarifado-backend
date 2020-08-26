package br.fatec.app.modules.v1.movimentacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovimentacaoService {

    private MovimentacaoRepository movimentacaoRepository;


    @Autowired
    public MovimentacaoService(
            MovimentacaoRepository movimentacaoRepository
    ) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

}
