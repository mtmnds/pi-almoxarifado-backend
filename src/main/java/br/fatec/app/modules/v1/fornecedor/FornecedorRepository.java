package br.fatec.app.modules.v1.fornecedor;


import br.fatec.app.modules.v1.fornecedor.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {}
