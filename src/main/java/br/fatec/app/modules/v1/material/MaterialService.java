package br.fatec.app.modules.v1.material;


import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MaterialService {

    private MaterialRepository materialRepository;


    @Autowired
    public MaterialService(
            MaterialRepository materialRepository
    ) {
        this.materialRepository = materialRepository;
    }


    public MaterialEntity cadastrarMaterial(MaterialEntity material) {
        return this.materialRepository.save(material);
    }


    public MaterialEntity alterarMaterial(MaterialEntity material) {
        return this.materialRepository.save(material);
    }


    public MaterialEntity buscarMaterial(long idMaterial) {
        Optional<MaterialEntity> material = this.materialRepository.findById(idMaterial);
        return material.orElse(null);
    }


    public List<MaterialEntity> listarTodosMateriais() {
        return this.materialRepository.findAll();
    }


    public void desativarMaterial(long idMaterial) {
        Optional<MaterialEntity> materialEntity = this.materialRepository.findById(idMaterial);

        if (materialEntity.isPresent()) {
            MaterialEntity material = materialEntity.get();
            material.setAtivo(false);
            this.materialRepository.save(material);
        }
    }


}
