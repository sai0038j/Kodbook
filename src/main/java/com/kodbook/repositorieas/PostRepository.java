package com.kodbook.repositorieas;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook.entities.Post;


public interface PostRepository extends JpaRepository<Post, Long>{

}
