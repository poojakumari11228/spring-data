package com.lab1.lab1.service.impl;

import com.lab1.lab1.Util.ListMapper;
import com.lab1.lab1.dto.PostDto;
import com.lab1.lab1.dto.UserDto;
import com.lab1.lab1.dto.UserDtoSimple;
import com.lab1.lab1.entity.User;
import com.lab1.lab1.repo.UserRepo;
import com.lab1.lab1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Override
    public List<UserDto> findUsers() {
        List<UserDto> userList = listMapper.mapList(userRepo.findAll(), new UserDto());
        return userList;
    }

    @Override
    public UserDto findUserById(long id) {
        System.out.println("***************");
        return modelMapper.map(userRepo.findById(id).get(),new UserDto().getClass());
    }

    @Override
    public void saveUser(UserDtoSimple userDto) {
        User user = modelMapper.map(userDto, new User().getClass());
        userRepo.save(user);
    }

    @Override
    public List<PostDto> getUserPosts(long id) {
        var user = userRepo.findById(id);
        List<PostDto> postDtos = listMapper.mapList(user.get().getPosts(), new PostDto());
        return postDtos;
    }

    @Override
    public List<UserDto> findUsersWithMoreThanOnePosts() {
        return listMapper.mapList(userRepo.findUsersWithMoreThanOnePost(), new UserDto());
    }
}
