package br.fatec.app.modules.v1.requisicao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequisicaoRepository extends JpaRepository<RequisicaoEntity, Long> {}
