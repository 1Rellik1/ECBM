package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import project.dto.UserToFind;
import project.entities.UserEntity;
import project.services.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<UserEntity> getUsers() throws Exception {
        return userService.getUsers();
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody UserEntity user) throws Exception {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String updateUser(@RequestBody UserToFind user) throws Exception {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody UserToFind user) throws Exception {
        return userService.deleteUser(user);
    }

    @PostMapping("/getuser")
    public UserEntity getUser(@RequestBody UserToFind user) {
        return userService.getUser(user);
    }

    @GetMapping("/getusername")
    public String getUserName() throws Exception {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("/getuseraccess")
    public String getUserAccess() throws Exception {
        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getAccesslist();
    }
}
