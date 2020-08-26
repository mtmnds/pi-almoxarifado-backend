package br.fatec.app.modules.v1.recebimento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecebimentoService {

    private RecebimentoRepository recebimentoRepository;


    @Autowired
    public RecebimentoService(
            RecebimentoRepository recebimentoRepository
    ) {
        this.recebimentoRepository = recebimentoRepository;
    }

}
