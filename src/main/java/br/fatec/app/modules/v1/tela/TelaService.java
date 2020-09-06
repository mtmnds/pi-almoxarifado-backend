package br.fatec.app.modules.v1.tela;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TelaService {

    private TelaRepository telaRepository;


    @Autowired
    public TelaService(
            TelaRepository telaRepository
    ) {
        this.telaRepository = telaRepository;
    }

}
