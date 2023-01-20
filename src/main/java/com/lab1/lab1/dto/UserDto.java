package com.lab1.lab1.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    long id;
    String name;
    List<PostDto> posts;
}
