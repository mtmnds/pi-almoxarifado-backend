package br.fatec.app.modules.v1.recebimento;


import br.fatec.app.modules.v1.recebimento.entity.RecebimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecebimentoRepository extends JpaRepository<RecebimentoEntity, Long> {}
