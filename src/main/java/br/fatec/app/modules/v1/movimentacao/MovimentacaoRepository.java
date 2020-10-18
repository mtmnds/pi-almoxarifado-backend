package br.fatec.app.modules.v1.movimentacao;


import br.fatec.app.modules.v1.movimentacao.entity.MovimentacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {}
