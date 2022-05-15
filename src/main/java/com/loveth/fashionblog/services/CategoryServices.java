package com.loveth.fashionblog.services;

import com.loveth.fashionblog.dto.CategoryDto;
import com.loveth.fashionblog.models.Category;
import org.springframework.stereotype.Service;


@Service
public interface CategoryServices {
    Category createCategory(CategoryDto categoryDto);
}
