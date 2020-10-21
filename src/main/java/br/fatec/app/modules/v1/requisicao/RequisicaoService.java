package br.fatec.app.modules.v1.requisicao;


import br.fatec.app.modules.v1.requisicao.entity.ItemRequisicaoEntity;
import br.fatec.app.modules.v1.requisicao.entity.RequisicaoEntity;
import br.fatec.app.modules.v1.requisicao.entity.StatusRequisicaoEntity;
import br.fatec.app.modules.v1.saldo.SaldoService;
import br.fatec.app.modules.v1.usuario.UsuarioRepository;
import br.fatec.app.modules.v1.usuario.UsuarioService;
import br.fatec.app.modules.v1.usuario.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class RequisicaoService {

    private RequisicaoRepository requisicaoRepository;

    private ItemRequisicaoRepository itemRequisicaoRepository;

    private SaldoService saldoService;

    private StatusRequisicaoRepository statusRequisicaoRepository;

    private UsuarioService usuarioService;


    @Autowired
    public RequisicaoService(
            RequisicaoRepository requisicaoRepository,
            ItemRequisicaoRepository itemRequisicaoRepository,
            SaldoService saldoService,
            StatusRequisicaoRepository statusRequisicaoRepository,
            UsuarioService usuarioService
    ) {
        this.requisicaoRepository = requisicaoRepository;
        this.itemRequisicaoRepository = itemRequisicaoRepository;
        this.saldoService = saldoService;
        this.statusRequisicaoRepository = statusRequisicaoRepository;
        this.usuarioService = usuarioService;
    }


    public RequisicaoEntity criarRequisicao(RequisicaoEntity requisicao) {
        return this.requisicaoRepository.save(requisicao);
    }


    public RequisicaoEntity alterarRequisicao(RequisicaoEntity requisicao) {
        return this.requisicaoRepository.save(requisicao);
    }


    public RequisicaoEntity buscarRequisicao(long idRequisicao) {
        Optional<RequisicaoEntity> requisicaoEntity = this.requisicaoRepository.findById(idRequisicao);
        return requisicaoEntity.orElse(null);
    }


    public List<RequisicaoEntity> listarTodasRequisicoes() {
        return this.requisicaoRepository.findAll();
    }


    @Transactional
    public void cancelarRequisicao(long idRequisicao) {
        Optional<RequisicaoEntity> requisicaoEntity = this.requisicaoRepository.findById(idRequisicao);

        if (requisicaoEntity.isPresent()) {
            RequisicaoEntity requisicao = requisicaoEntity.get();
            requisicao.setAtivo(false);
            this.requisicaoRepository.save(requisicao);

            for (ItemRequisicaoEntity itemRequisicao : requisicao.getItens()) {
                itemRequisicao.setAtivo(false);
                this.itemRequisicaoRepository.save(itemRequisicao);
            }
        }
    }


    @Transactional
    public void aprovarRequisicao(long idRequisicao, long idUsuarioAtendente) {
        Optional<RequisicaoEntity> requisicaoOp = this.requisicaoRepository.findById(idRequisicao);
        Optional<StatusRequisicaoEntity> statusRequisicaoOp = this.statusRequisicaoRepository.findById(2L);
        UsuarioEntity usuarioAtendente = this.usuarioService.buscarUsuario(idUsuarioAtendente);

        if (requisicaoOp.isPresent() && statusRequisicaoOp.isPresent() && usuarioAtendente != null) {
            StatusRequisicaoEntity statusRequisicaoEntity = statusRequisicaoOp.get();

            RequisicaoEntity requisicao = requisicaoOp.get();
            requisicao.setStatusRequisicao(statusRequisicaoEntity);
            requisicao.setAtendente(usuarioAtendente);
            requisicao.setDataAtendimento(new Date());
            this.requisicaoRepository.save(requisicao);

            for (ItemRequisicaoEntity itemRequisicao : requisicao.getItens()) {
                // TODO: Criar lógica de decrementar saldo na origem e incrementar no destino
                // - Criar um local de estoque para o id do técnico, caso ele não tenha ainda
                // - Definir o local de origem
                // - Usar o service da movimentação, onde a origem é o local de estoque e o destino o estoque do técnico
            }
        }
    }

}
