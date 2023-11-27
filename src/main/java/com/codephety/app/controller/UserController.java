package com.codephety.app.controller;

import com.codephety.app.dto.User;
import com.codephety.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("fetch")
    public ResponseEntity<User> fetchUser(@RequestParam int id) {
        return ResponseEntity.ok(userService.fetchUser(id));
    }

    @PatchMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @PutMapping("replace")
    public ResponseEntity<User> replaceUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.replaceUser(user));
    }


    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> removeUser(@PathVariable int id) {
        userService.removeUser(id);
        return ResponseEntity.ok("User Removed");
    }

}
