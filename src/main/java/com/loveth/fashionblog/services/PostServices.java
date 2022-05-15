package com.loveth.fashionblog.services;

import com.loveth.fashionblog.dto.PostDto;
import com.loveth.fashionblog.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {
    Post createPost(PostDto post, Long id);

    List<Post> getAllPosts();


    Post editPost(long pid, long uid, PostDto postDto);

    Post deletePost(long pid, long uid);




}
