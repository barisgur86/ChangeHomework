package com.change.controller;

import com.change.dto.UserDto;
import com.change.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class RestController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUserList();
    }

}
