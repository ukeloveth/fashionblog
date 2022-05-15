package com.loveth.fashionblog.services.serviceImpl;

import com.loveth.fashionblog.enums.Role;
import com.loveth.fashionblog.dto.PostDto;
import com.loveth.fashionblog.exception.NotFoundException;
import com.loveth.fashionblog.exception.UserNotAuthorizedException;
import com.loveth.fashionblog.models.Post;
import com.loveth.fashionblog.models.User;
import com.loveth.fashionblog.repository.PostRepository;
import com.loveth.fashionblog.repository.UserRepository;
import com.loveth.fashionblog.services.PostServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class PostServiceImpl implements PostServices {

    private final PostRepository postRepo;
    private final UserRepository userRepo;

    @Autowired
    public PostServiceImpl(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Post createPost(PostDto post, Long id) {
        Optional<User> existingUser = userRepo.findById(id);

        if (existingUser.get().getRole() == Role.ADMIN) {
            Post newPost = new Post();
            newPost.setTitle(post.getTitle());
            newPost.setProductDescription(post.getProductDescription());
            newPost.setProductImageUrl(post.getProductImageUrl());
            return postRepo.save(newPost);
        } else {
            throw new UserNotAuthorizedException("User not authorized for this request");
        }

    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }



    @Override
    public Post editPost(long pid, long uid, PostDto postDto) {
        Post post = postRepo.getById(pid);
        User user = userRepo.findById(uid).orElseThrow(() -> new NotFoundException("User not found"));
        var userPosts = user.getPosts();
        for (Post p : userPosts) {
            if (post.getTitle().equals(p.getTitle())) {
                post.setProductDescription(postDto.getProductDescription());
                postRepo.save(post);
            } else {
                log.info("Invalid User");
                throw new UserNotAuthorizedException("user not authorized");
            }
        }
        return post;
    }



    @Override
    public Post deletePost(long pid, long uid) {
//        Post post = postRepo.getById(pid);
//        if(){}

        return null;
    }

}
