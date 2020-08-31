package br.fatec.app.modules.v1.estoque;


import br.fatec.app.modules.v1.estoque.entity.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {}
