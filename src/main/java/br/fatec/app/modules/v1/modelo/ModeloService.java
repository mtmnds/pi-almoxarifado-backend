package br.fatec.app.modules.v1.modelo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModeloService {

    private ModeloRepository modeloRepository;


    @Autowired
    public ModeloService(
            ModeloRepository modeloRepository
    ) {
        this.modeloRepository = modeloRepository;
    }

}
