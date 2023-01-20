package com.lab1.lab1.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.lab1.lab1.service.PostService;
import com.lab1.lab1.dto.PostDto;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {


    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable int id){
        return postService.getById(id);
    }

    @PostMapping
    public void addPost(@RequestBody PostDto postDto){
        postService.savePost(postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){
        postService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id ,@RequestBody PostDto postDto){
        postService.updateById(id, postDto);
    }

}
