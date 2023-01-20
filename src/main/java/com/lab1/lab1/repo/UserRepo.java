package com.lab1.lab1.repo;

import com.lab1.lab1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.posts WHERE SIZE(u.posts) > 1")
    List<User> findUsersWithMoreThanOnePost();

//    @Query("SELECT u FROM User u JOIN FETCH u.posts")
//    List<User> findAllUsersWithPosts();

}
