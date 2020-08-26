package br.fatec.app.modules.v1.menu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/menu")
public class MenuController {

    private MenuService menuService;


    @Autowired
    public MenuController(
            MenuService menuService
    ) {
        this.menuService = menuService;
    }

}
