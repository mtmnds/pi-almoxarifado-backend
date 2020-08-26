package br.fatec.app.modules.v1.movimentacao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {}
