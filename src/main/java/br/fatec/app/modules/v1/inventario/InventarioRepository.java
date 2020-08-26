package br.fatec.app.modules.v1.inventario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Long> {}
