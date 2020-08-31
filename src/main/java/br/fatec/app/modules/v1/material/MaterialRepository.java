package br.fatec.app.modules.v1.material;


import br.fatec.app.modules.v1.material.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {}
