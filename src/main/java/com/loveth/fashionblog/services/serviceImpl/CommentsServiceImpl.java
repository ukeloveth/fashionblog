package com.loveth.fashionblog.services.serviceImpl;

import com.loveth.fashionblog.dto.CommentsDto;
import com.loveth.fashionblog.dto.PostDto;
import com.loveth.fashionblog.models.Comments;
import com.loveth.fashionblog.repository.CommentsRepository;
import com.loveth.fashionblog.services.CommentsServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsServices {

    private CommentsRepository commentsRepo;

    public CommentsServiceImpl(CommentsRepository commentsRepo) {
        this.commentsRepo = commentsRepo;
    }

    @Override
    public Comments createComments(CommentsDto commentsDto) {

        Comments comments = new Comments();
        comments.setCommentContent(commentsDto.getCommentContent());
        commentsRepo.save(comments);
        return comments;
    }

    @Override
    public Comments editComment(long cid, long uid, PostDto postDto) {
        return null;
    }

    @Override
    public List<Comments> getAllPostComments(long pid) {
        return null;
    }

    @Override
    public Comments deleteComment(long cid, long uid) {
        return null;
    }
}
