package com.change.controller;

import com.change.dto.UserDto;
import com.change.entity.User;
import com.change.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class RestController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUserList();
    }


    @PostMapping("/create")
    private long saveUser(@RequestBody User user)
    {
        userService.saveOrUpdate(user);
        return user.getId();
    }

    @DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable("id") long id)
    {
        userService.delete(id);
    }

    @PutMapping("/update")
    private User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

}
