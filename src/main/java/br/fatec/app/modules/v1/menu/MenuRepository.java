package br.fatec.app.modules.v1.menu;


import br.fatec.app.modules.v1.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {}
