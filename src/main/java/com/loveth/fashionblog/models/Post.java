package com.loveth.fashionblog.models;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="blog_posts")
public class Post extends  Base{

    private String title;

    private String productImageUrl;

    private String productDescription;

    @OneToMany
    Set<Likes> likes = new HashSet<>();

    @OneToMany
    Set<Comments> comments = new HashSet<>();

    @ManyToOne
    private User user;

}
