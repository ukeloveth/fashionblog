package com.loveth.fashionblog.services;

import com.loveth.fashionblog.dto.CommentsDto;
import com.loveth.fashionblog.dto.PostDto;
import com.loveth.fashionblog.models.Comments;
import com.loveth.fashionblog.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;


@Service
public interface CommentsServices {

    Comments createComments(CommentsDto commentsDto);

    Comments editComment(long cid, long uid, PostDto postDto);

    List<Comments> getAllPostComments(long pid);

    Comments deleteComment(long cid, long uid);

}
