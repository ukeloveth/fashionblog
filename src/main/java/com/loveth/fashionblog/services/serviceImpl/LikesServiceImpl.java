package com.loveth.fashionblog.services.serviceImpl;

import com.loveth.fashionblog.models.Likes;
import com.loveth.fashionblog.repository.LikesRepository;
import com.loveth.fashionblog.services.LikesServices;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesServices {

    private LikesRepository likesRepos;

    public LikesServiceImpl(LikesRepository likesRepos) {
        this.likesRepos = likesRepos;
    }

    @Override
    public Likes createLikes() {
        return null;
    }

    @Override
    public long likePost(long uid, long pid) {
        return 0;
    }

    @Override
    public long unlikePost(long uid, long pid) {
        return 0;
    }

    @Override
    public long likeComment(long uid, long cid) {
        return 0;
    }

    @Override
    public long unlikeComment(long uid, long cid) {
        return 0;
    }


}
