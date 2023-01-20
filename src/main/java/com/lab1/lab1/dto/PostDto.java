package com.lab1.lab1.dto;

import lombok.Data;
@Data
public class PostDto {
    long id;
    String title;
    String content;
    String author;
    long userId;

}
