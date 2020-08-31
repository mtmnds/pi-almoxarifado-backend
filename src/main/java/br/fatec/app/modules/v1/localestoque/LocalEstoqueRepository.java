package br.fatec.app.modules.v1.localestoque;


import br.fatec.app.modules.v1.localestoque.entity.LocalEstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalEstoqueRepository extends JpaRepository<LocalEstoqueEntity, Long> {}