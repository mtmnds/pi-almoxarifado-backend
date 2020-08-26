package br.fatec.app.modules.v1.estoque;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {}
