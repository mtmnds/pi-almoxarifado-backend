package br.fatec.app.modules.v1.perfil;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {}
