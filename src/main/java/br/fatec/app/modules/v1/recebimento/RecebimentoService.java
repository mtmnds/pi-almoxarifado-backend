package br.fatec.app.modules.v1.recebimento;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.app.modules.v1.localestoque.LocalEstoqueRepository;
import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import br.fatec.app.modules.v1.movimentacao.MovimentacaoService;
import br.fatec.app.modules.v1.movimentacao.entity.MovimentacaoEntity;
import br.fatec.app.modules.v1.recebimento.entity.ItemNotaFiscalEntity;
import br.fatec.app.modules.v1.recebimento.entity.NotaFiscalEntity;


@Service
public class RecebimentoService {
	private MovimentacaoService movimentacaoService;
	
    private NotaFiscalRepository notaFiscalRepository;
    private LocalEstoqueRepository localEstoqueRepository;

    @Autowired
    public RecebimentoService(
    		MovimentacaoService movimentacaoService,
    		
            NotaFiscalRepository notaFiscalRepository,
            LocalEstoqueRepository localEstoqueRepository
    ) {
    	this.movimentacaoService = movimentacaoService;
    	
        this.notaFiscalRepository = notaFiscalRepository;
        this.localEstoqueRepository = localEstoqueRepository;
    }
    
    public List<NotaFiscalEntity> listarNotasFiscais() {
    	return this.notaFiscalRepository.findAll();
    }
    
    public NotaFiscalEntity gerarRecebimento (NotaFiscalEntity notaFiscal) throws Exception {
    	NotaFiscalEntity notaFiscalCadastrada = this.notaFiscalRepository.save(notaFiscal);
    	
    	Optional<LocalEstoqueEntity> localOrigem = this.localEstoqueRepository.findById(1L);
    	Optional<LocalEstoqueEntity> localDestino = this.localEstoqueRepository.findById(2L);
    	
    	for (ItemNotaFiscalEntity itemNota: notaFiscalCadastrada.getItens()) {
    		MovimentacaoEntity movimentacao = new MovimentacaoEntity();
    		movimentacao.setAtivo(true);
    		movimentacao.setDataMovimentacao(new Date());
    		movimentacao.setLocalOrigem(localOrigem.get());
    		movimentacao.setLocalDestino(localDestino.get());
    		movimentacao.setMaterial(itemNota.getMaterial());
    		movimentacao.setQuantidade(itemNota.getQuantidade());
    		movimentacao.setUsuarioMovimentacao(notaFiscalCadastrada.getUsuario());
    		this.movimentacaoService.movimentarSaldo(movimentacao);
    	}
    		
    	return notaFiscalCadastrada;
    	    	
    }
}
