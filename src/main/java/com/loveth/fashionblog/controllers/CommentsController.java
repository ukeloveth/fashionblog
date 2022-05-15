package com.loveth.fashionblog.controllers;


import com.loveth.fashionblog.dto.CommentsDto;
import com.loveth.fashionblog.models.Comments;
import com.loveth.fashionblog.services.CommentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/comments")
@RestController
public class CommentsController {

    @Autowired
    private CommentsServices commentsServices;

    @PostMapping
    public Comments createComments(@RequestBody CommentsDto commentsDto) {
        return commentsServices.createComments(commentsDto);
    }
}
