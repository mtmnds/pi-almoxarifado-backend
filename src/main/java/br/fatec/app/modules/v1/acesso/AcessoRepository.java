package br.fatec.app.modules.v1.acesso;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcessoRepository extends JpaRepository<AcessoEntity, Long> {}
