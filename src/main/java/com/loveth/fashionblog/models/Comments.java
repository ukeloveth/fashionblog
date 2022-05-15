package com.loveth.fashionblog.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog_comments")
public class Comments extends Base{

    private String commentContent;

    @OneToMany
    Set<Likes> likes = new HashSet<>();
}
