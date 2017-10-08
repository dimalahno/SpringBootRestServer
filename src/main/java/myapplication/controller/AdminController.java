package myapplication.controller;


import myapplication.model.User;
import myapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController()
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@RequestBody User user, @PathVariable("id") Integer id){
        User userUpd = userService.getUserById(id);
        userUpd.setName(user.getName());
        userUpd.setAge(user.getAge());
        userUpd.setEmail(user.getEmail());
        userUpd.setPassword(user.getPassword());
        userUpd.setRole(user.getRole());
        userService.updateUser(userUpd);
    }
}
