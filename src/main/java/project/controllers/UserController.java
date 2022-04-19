package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import project.dto.UserToFind;
import project.entities.UserEntity;
import project.services.UserService;

import java.util.List;

/**
 * Контроллер для работы с сущностями пользователей
 */
@RestController
public class UserController {
    //Сервис для работы с сущностями пользователей
    @Autowired
    private UserService userService;

    /**
     * Получение всех пользователей
     * @return
     * список пользователей
     */
    @GetMapping("/getusers")
    public List<UserEntity> getUsers(){
        return userService.getUsers();
    }

    /**
     * Добавление пользователя
     * @param user
     * Дто сущность с данными нового пользователя
     * @return
     * сообщение о результате добавления
     */
    @PostMapping("/adduser")
    public String addUser(@RequestBody UserEntity user) {
        return userService.addUser(user);
    }

    /**
     * Обновление данных пользователя
     * @param user
     * Дто сущность с обновленными данными пользователя
     * @return
     * результат обновления
     */
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String updateUser(@RequestBody UserToFind user){
        return userService.updateUser(user);
    }

    /**
     * Удаление пользователя
     * @param user
     * Дто сущность пользователя с его идентификатором
     * @return
     * результат удаления
     */
    @RequestMapping(value = "/deleteuser", method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody UserToFind user){
        return userService.deleteUser(user);
    }

    /**
     * Получение пользователя по его идентификатору
     * @param user
     * Дто сущность пользователя с его идентификатором
     * @return
     * данные пользователя
     */
    @PostMapping("/getuser")
    public UserEntity getUser(@RequestBody UserToFind user) {
        return userService.getUser(user);
    }

    /**
     * Получение имени пользователя
     * @return
     * имя пользователя
     */
    @GetMapping("/getusername")
    public String getUserName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    /**
     * Получение уровня доступа пользователя
     * @return
     * уровень доступа
     */
    @GetMapping("/getuseraccess")
    public String getUserAccess(){
        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getAccesslist();
    }
}
