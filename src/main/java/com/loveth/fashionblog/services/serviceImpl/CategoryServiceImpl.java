package com.loveth.fashionblog.services.serviceImpl;

import com.loveth.fashionblog.dto.CategoryDto;
import com.loveth.fashionblog.models.Category;
import com.loveth.fashionblog.repository.CategoryRepository;
import com.loveth.fashionblog.services.CategoryServices;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryServices {

    private CategoryRepository categoryRepo;

    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category createCategory(CategoryDto categoryDto) {
    Category category = new Category();
       category.setCategoryName(categoryDto.getCategoryName());
       category.setCategoryDescription(categoryDto.getCategoryDescription());
       categoryRepo.save(category);
        return category;
    }
}
