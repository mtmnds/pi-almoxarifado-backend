package br.fatec.app.modules.v1.marca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MarcaService {

    private MarcaRepository marcaRepository;


    @Autowired
    public MarcaService(
            MarcaRepository marcaRepository
    ) {
        this.marcaRepository = marcaRepository;
    }

}
