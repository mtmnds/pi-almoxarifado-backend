package br.fatec.app.modules.v1.recebimento;


import br.fatec.app.modules.v1.recebimento.entity.ItemNotaFiscalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotaFiscalRepository extends JpaRepository<ItemNotaFiscalEntity, Long> {}
