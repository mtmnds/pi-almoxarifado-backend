package br.fatec.app.modules.v1.modelo;


import br.fatec.app.modules.v1.modelo.entity.ModeloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModeloRepository extends JpaRepository<ModeloEntity, Long> {}
