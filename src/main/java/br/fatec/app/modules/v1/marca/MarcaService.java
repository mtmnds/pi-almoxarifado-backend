package br.fatec.app.modules.v1.marca;


import br.fatec.app.modules.v1.marca.entity.MarcaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MarcaService {

    private MarcaRepository marcaRepository;


    @Autowired
    public MarcaService(
            MarcaRepository marcaRepository
    ) {
        this.marcaRepository = marcaRepository;
    }


    public MarcaEntity cadastrarMarca(MarcaEntity marca) {
        return this.marcaRepository.save(marca);
    }


    public MarcaEntity alterarMarca(MarcaEntity marca) {
        return this.marcaRepository.save(marca);
    }


    public MarcaEntity buscarMarca(long idMarca) {
        Optional<MarcaEntity> marca = this.marcaRepository.findById(idMarca);
        return marca.orElse(null);
    }


    public List<MarcaEntity> listarTodasMarcas() {
        return this.marcaRepository.findAll();
    }


    public void desativarMarca(long idMarca) {
        Optional<MarcaEntity> marcaEntity = this.marcaRepository.findById(idMarca);

        if (marcaEntity.isPresent()) {
            MarcaEntity marca = marcaEntity.get();
            marca.setAtivo(false);
            this.marcaRepository.save(marca);
        }
    }


}
