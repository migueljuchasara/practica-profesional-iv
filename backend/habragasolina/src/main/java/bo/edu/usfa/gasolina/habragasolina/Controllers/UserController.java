package bo.edu.usfa.gasolina.habragasolina.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.usfa.gasolina.habragasolina.Entities.Authentication;
import bo.edu.usfa.gasolina.habragasolina.Entities.User;
import bo.edu.usfa.gasolina.habragasolina.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

   public UserController(UserService userService) {
    this.userService = userService;
   }

   @PostMapping("")
   public ResponseEntity<User> saveUser(@RequestBody User user){
    User newUser = userService.saveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
   }
   
   @PostMapping("/login")
   public ResponseEntity<User> aunthenticateUser(@RequestBody Authentication user){
    User newUser = userService.Authenticate(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
   }
}
