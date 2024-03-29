package com.devsuperior.hroauth.resources;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
       try {
           User user = userService.loadUserByUsername(email);
           return ResponseEntity.ok(user);
       } catch(IllegalArgumentException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

}
