package br.fatec.app.modules.v1.material;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MaterialService {

    private MaterialRepository materialRepository;


    @Autowired
    public MaterialService(
            MaterialRepository materialRepository
    ) {
        this.materialRepository = materialRepository;
    }
}
