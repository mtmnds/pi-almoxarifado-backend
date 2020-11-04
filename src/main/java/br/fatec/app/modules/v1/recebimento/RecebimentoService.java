package br.fatec.app.modules.v1.recebimento;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.app.modules.v1.recebimento.entity.NotaFiscalEntity;


@Service
public class RecebimentoService {

    private NotaFiscalRepository notaFiscalRepository;

    private ItemNotaFiscalRepository itemNotaFiscalRepository;


    @Autowired
    public RecebimentoService(
            NotaFiscalRepository notaFiscalRepository,
            ItemNotaFiscalRepository itemNotaFiscalRepository
    ) {
        this.notaFiscalRepository = notaFiscalRepository;
        this.itemNotaFiscalRepository = itemNotaFiscalRepository;
    }
    
    public List<NotaFiscalEntity> listarNotasFiscais() {
    	return this.notaFiscalRepository.findAll();
    }
}
