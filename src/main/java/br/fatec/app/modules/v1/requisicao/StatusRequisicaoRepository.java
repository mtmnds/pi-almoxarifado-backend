package br.fatec.app.modules.v1.requisicao;


import br.fatec.app.modules.v1.requisicao.entity.StatusRequisicaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusRequisicaoRepository extends JpaRepository<StatusRequisicaoEntity, Long> {}
