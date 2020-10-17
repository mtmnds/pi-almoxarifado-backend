package br.fatec.app.modules.v1.modelo;

import br.fatec.app.modules.v1.modelo.entity.ModeloEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ModeloService {

    private ModeloRepository modeloRepository;


    @Autowired
    public ModeloService(
            ModeloRepository modeloRepository
    ) {
        this.modeloRepository = modeloRepository;
    }


    public ModeloEntity cadastrarModelo(ModeloEntity modelo) {
        return this.modeloRepository.save(modelo);
    }


    public ModeloEntity alterarModelo(ModeloEntity modelo) {
        return this.modeloRepository.save(modelo);
    }


    public ModeloEntity buscarModelo(long idModelo) {
        Optional<ModeloEntity> modelo = this.modeloRepository.findById(idModelo);
        return modelo.orElse(null);
    }


    public List<ModeloEntity> listarTodosModelos() {
        return this.modeloRepository.findAll();
    }


    public void desativarModelo(long idModelo) {
        Optional<ModeloEntity> modeloEntity = this.modeloRepository.findById(idModelo);

        if (modeloEntity.isPresent()) {
            ModeloEntity modelo = modeloEntity.get();
            modelo.setAtivo(false);
            this.modeloRepository.save(modelo);
        }
    }

}
