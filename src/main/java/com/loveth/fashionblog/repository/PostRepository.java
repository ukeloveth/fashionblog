package com.loveth.fashionblog.repository;

import com.loveth.fashionblog.dto.PostDto;
import com.loveth.fashionblog.models.Post;
import com.loveth.fashionblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {


    List<Post>findAllByUser(User user);

    Post getPostById (long pid);

    Post deletePostById(long pid);

}
