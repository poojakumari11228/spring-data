package com.lab1.lab1.service;

import com.lab1.lab1.dto.PostDto;
import com.lab1.lab1.dto.UserDto;
import com.lab1.lab1.dto.UserDtoSimple;
import com.lab1.lab1.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<UserDto> findUsers();
    UserDto findUserById(long id);

    void saveUser(UserDtoSimple user);

    List<PostDto> getUserPosts(long id);

    List<UserDto> findUsersWithMoreThanOnePosts();
}
