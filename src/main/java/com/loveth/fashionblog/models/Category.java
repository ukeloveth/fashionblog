package com.loveth.fashionblog.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Category extends Base{

    private  String categoryName;

    private  String categoryDescription;

    @OneToMany
    private Set<Post> posts;
}
