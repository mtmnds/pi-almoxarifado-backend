package br.fatec.app.modules.v1.tela;


import br.fatec.app.modules.v1.tela.entity.TelaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TelaService {

    private TelaRepository telaRepository;


    @Autowired
    public TelaService(
            TelaRepository telaRepository
    ) {
        this.telaRepository = telaRepository;
    }


    public TelaEntity cadastrarTela(TelaEntity tela) {
        return this.telaRepository.save(tela);
    }


    public TelaEntity alterarTela(TelaEntity tela) {
        return this.telaRepository.save(tela);
    }


    public TelaEntity buscarTela(long idTela) {
        Optional<TelaEntity> tela = this.telaRepository.findById(idTela);
        return tela.orElse(null);
    }


    public List<TelaEntity> listarTodasTelas() {
        return this.telaRepository.findAll();
    }


    public void desativarTela(long idTela) {
        Optional<TelaEntity> telaEntity = this.telaRepository.findById(idTela);

        if (telaEntity.isPresent()) {
            TelaEntity tela = telaEntity.get();
            tela.setAtivo(false);
            this.telaRepository.save(tela);
        }
    }


}
