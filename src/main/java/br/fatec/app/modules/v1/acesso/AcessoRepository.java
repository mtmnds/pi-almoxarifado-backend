package br.fatec.app.modules.v1.acesso;


import br.fatec.app.modules.v1.acesso.entity.AcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcessoRepository extends JpaRepository<AcessoEntity, Long> {}
