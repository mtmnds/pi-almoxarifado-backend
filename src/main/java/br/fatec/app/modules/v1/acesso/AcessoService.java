package br.fatec.app.modules.v1.acesso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AcessoService {

    private AcessoRepository acessoRepository;


    @Autowired
    public AcessoService(
            AcessoRepository acessoRepository
    ) {
        this.acessoRepository = acessoRepository;
    }

}
