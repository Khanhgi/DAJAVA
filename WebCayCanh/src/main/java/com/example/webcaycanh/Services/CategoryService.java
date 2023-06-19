package com.example.webcaycanh.Services;

import com.example.webcaycanh.entity.Category;
import com.example.webcaycanh.Repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;



@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryReposity;

    public List<Category> getAllCategories() {
        return categoryReposity.findAll();
    }

    public Category getCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryReposity.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        }else {
            throw new RuntimeException("Category not found");
        }
    }

    public Category saveCategory(Category category){
        return categoryReposity.save(category);
    }

    public void deleteCategory(Long id){
        categoryReposity.deleteById(id);
    }
}
