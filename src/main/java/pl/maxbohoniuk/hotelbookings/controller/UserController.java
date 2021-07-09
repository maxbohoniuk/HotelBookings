package pl.maxbohoniuk.hotelbookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maxbohoniuk.hotelbookings.model.User;
import pl.maxbohoniuk.hotelbookings.service.UserService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService UserService) {
        this.userService = UserService;

        User u1 = new User("Rhonda","French","rfrench@gmail.com", LocalDate.of(1994,5,18),"Poland");
        User u2 = new User("Austen","Frank","afrank@gmail.com", LocalDate.of(2001,11,20),"Poland");
        User u3 = new User("Codey","Harrington","charrington@gmail.com", LocalDate.of(1987,2,7),"USA");

        userService.addUsers(u1,u2,u3);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}