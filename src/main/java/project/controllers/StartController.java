package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  Начальный контроллер отвечающий за вывод страниц
 */
@Controller
public class StartController{
    /**
     * Вывод главной страницы приложения
     * @return
     * Главная страница
     */
    @GetMapping("/")
    public String start() {
        return "index";
    }

    /**
     * Вывод страницы авторизации
     * @return
     * страница авторизации
     */
    @GetMapping("/login")
    public String afterLogin() {
        return "login";
    }

    /**
     * Вывод страницы ошибки при авторизации
     * @return
     * страница ошибки при авторизации
     */
    @GetMapping("/login-error")
    public String errorLogin() {
        return "loginError";
    }

}
