package com.loveth.fashionblog.models;

import com.loveth.fashionblog.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="blog_users")
public class User  extends  Base{

    private String username;

    private  String email;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String password;

    @OneToMany
    private Set<Post> posts = new HashSet<>();

    @OneToMany
    private Set<Comments> comments = new HashSet<>();

    public User() {
        super();
    }
}
