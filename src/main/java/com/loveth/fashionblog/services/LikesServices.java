package com.loveth.fashionblog.services;

import com.loveth.fashionblog.models.Likes;
import org.springframework.stereotype.Service;

@Service
public interface LikesServices {
    Likes createLikes();

    long likePost(long uid, long pid);

    long unlikePost(long uid, long pid);

    long likeComment(long uid, long cid);

    long unlikeComment(long uid, long cid);


}
