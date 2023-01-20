package com.lab1.lab1.controller;

import com.lab1.lab1.dto.PostDto;
import com.lab1.lab1.dto.UserDto;
import com.lab1.lab1.dto.UserDtoSimple;
import com.lab1.lab1.entity.User;
import com.lab1.lab1.service.PostService;
import com.lab1.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserDto> getUsers() {
        return userService.findUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUsers(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public void saveUser(@RequestBody UserDtoSimple userDtoSimple){
        userService.saveUser(userDtoSimple);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getUsersPost(@PathVariable long id) {
        return userService.getUserPosts(id);
    }
    @GetMapping("/posts")
    public List<UserDto> getUsersWithMoreThanOnePost() {
        return userService.findUsersWithMoreThanOnePosts();
    }


}
