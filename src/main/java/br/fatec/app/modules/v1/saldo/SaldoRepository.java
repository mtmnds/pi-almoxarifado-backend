package br.fatec.app.modules.v1.saldo;


import br.fatec.app.modules.v1.saldo.entity.SaldoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SaldoRepository extends JpaRepository<SaldoEntity, Long> {

    Optional<SaldoEntity> findByIdMaterialAndIdLocalEstoque(long idMaterial, long idLocalEstoque);

}
