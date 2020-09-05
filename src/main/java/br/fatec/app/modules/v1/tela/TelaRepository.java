package br.fatec.app.modules.v1.tela;


import br.fatec.app.modules.v1.tela.entity.TelaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TelaRepository extends JpaRepository<TelaEntity, Long> {}
