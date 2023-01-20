package com.lab1.lab1.service.impl;

import com.lab1.lab1.entity.User;
import com.lab1.lab1.repo.UserRepo;
import com.lab1.lab1.service.PostService;
import com.lab1.lab1.dto.PostDto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.lab1.lab1.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import com.lab1.lab1.Util.ListMapper;
import com.lab1.lab1.entity.Post;

@Service
@lombok.RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<PostDto> findAll() {
        return listMapper.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(postRepo.findById(id), new PostDto().getClass());
    }

    @Override
    public void savePost(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updateById(long id, PostDto postDto) {
        Optional<Post> post = postRepo.findById(id);
        if (post.isPresent()) {
            Optional<User> user = userRepo.findById(postDto.getUserId());
            Post updatePost = new Post(id, postDto.getTitle(), postDto.getContent(), postDto.getAuthor(), user.get());
            postRepo.save(updatePost);
        }
    }
}
