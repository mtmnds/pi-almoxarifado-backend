package br.fatec.app.modules.v1.menu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuService {

    private MenuRepository menuRepository;


    @Autowired
    public MenuService(
            MenuRepository menuRepository
    ) {
        this.menuRepository = menuRepository;
    }

}
