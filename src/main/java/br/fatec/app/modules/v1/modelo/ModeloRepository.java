package br.fatec.app.modules.v1.modelo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModeloRepository extends JpaRepository<ModeloEntity, Long> {}
