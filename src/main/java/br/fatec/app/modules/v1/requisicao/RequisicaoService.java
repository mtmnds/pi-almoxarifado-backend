package br.fatec.app.modules.v1.requisicao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RequisicaoService {

    private RequisicaoRepository requisicaoRepository;

    private ItemRequisicaoRepository itemRequisicaoRepository;


    @Autowired
    public RequisicaoService(
            RequisicaoRepository requisicaoRepository,
            ItemRequisicaoRepository itemRequisicaoRepository
    ) {
        this.requisicaoRepository = requisicaoRepository;
        this.itemRequisicaoRepository = itemRequisicaoRepository;
    }

}
