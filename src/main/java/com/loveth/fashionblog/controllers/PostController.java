package com.loveth.fashionblog.controllers;

import com.loveth.fashionblog.dto.PostDto;
import com.loveth.fashionblog.models.Post;
import com.loveth.fashionblog.services.PostServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostServices postService;

    public PostController(PostServices postService) {
        this.postService = postService;
    }

    @PostMapping("/{userId}")
    public Post createPost(@RequestBody PostDto postDto, @PathVariable("userId") Long id) {
        return postService.createPost(postDto, id);
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }


    @PutMapping("/editPost/{pid}")
    public Post editPost(@RequestParam long uid, @PathVariable long pid, @RequestBody PostDto postDto){
        return postService.editPost(pid,uid,postDto);

    }


}
