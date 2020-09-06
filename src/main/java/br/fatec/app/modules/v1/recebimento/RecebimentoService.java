package br.fatec.app.modules.v1.recebimento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

}
