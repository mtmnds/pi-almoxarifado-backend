package br.fatec.app.modules.v1.acesso;

import br.fatec.app.modules.v1.acesso.entity.AcessoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class AcessoService {

    private AcessoRepository acessoRepository;


    @Autowired
    public AcessoService(
            AcessoRepository acessoRepository
    ) {
        this.acessoRepository = acessoRepository;
    }


    public AcessoEntity cadastrarAcesso(AcessoEntity acesso) {
        return this.acessoRepository.save(acesso);
    }


    public AcessoEntity alterarAcesso(AcessoEntity acesso) {
        return this.acessoRepository.save(acesso);
    }


    public AcessoEntity buscarAcesso(long idAcesso) {
        Optional<AcessoEntity> acesso = this.acessoRepository.findById(idAcesso);
        return acesso.orElse(null);
    }


    public List<AcessoEntity> listarTodosAcessos() {
        return this.acessoRepository.findAll();
    }


    public void desativarAcesso(long idAcesso) {
        Optional<AcessoEntity> acessoEntity = this.acessoRepository.findById(idAcesso);

        if (acessoEntity.isPresent()) {
            AcessoEntity acesso = acessoEntity.get();
            acesso.setAtivo(false);
            this.acessoRepository.save(acesso);
        }
    }

}
