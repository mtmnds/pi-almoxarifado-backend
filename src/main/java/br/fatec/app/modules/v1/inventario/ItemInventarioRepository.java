package br.fatec.app.modules.v1.inventario;


import br.fatec.app.modules.v1.inventario.entity.ItemInventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemInventarioRepository extends JpaRepository<ItemInventarioEntity, Long> {}
