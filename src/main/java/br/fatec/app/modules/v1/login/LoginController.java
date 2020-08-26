package br.fatec.app.modules.v1.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    private LoginService loginService;


    @Autowired
    public LoginController(
            LoginService loginService
    ) {
        this.loginService = loginService;
    }

}
