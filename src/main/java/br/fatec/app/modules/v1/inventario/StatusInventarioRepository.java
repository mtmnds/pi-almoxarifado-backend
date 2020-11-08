package br.fatec.app.modules.v1.inventario;


import br.fatec.app.modules.v1.inventario.entity.StatusInventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusInventarioRepository extends JpaRepository<StatusInventarioEntity, Long> {}
