package com.lab1.lab1.repo;

import com.lab1.lab1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {


}
