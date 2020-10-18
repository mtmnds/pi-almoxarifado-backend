package br.fatec.app.configuracoes;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("")
public class SwaggerController {


    @RequestMapping(
            method = RequestMethod.GET,
            value = {"", "/"}
    )
    public ModelAndView documentacao(ModelMap modelMap) {
        return new ModelAndView("redirect:/swagger-ui.html", modelMap);
    }


}
