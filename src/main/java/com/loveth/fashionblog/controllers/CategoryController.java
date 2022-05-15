package com.loveth.fashionblog.controllers;

import com.loveth.fashionblog.dto.CategoryDto;
import com.loveth.fashionblog.models.Category;
import com.loveth.fashionblog.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/categories")
@RestController
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @PostMapping
    public Category createCategory(@RequestBody CategoryDto categoryDto){

        return categoryServices.createCategory(categoryDto);
    }
}
