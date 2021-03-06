package br.fatec.app.modules.v1.marca;


import br.fatec.app.modules.v1.marca.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {}
