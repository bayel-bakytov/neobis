package com.example.books.service;

import com.example.books.entity.Category;
import com.example.books.excepetion.NotFoundException;
import com.example.books.model.CategoryModel;
import com.example.books.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<CategoryModel> convertCategoryToModel(Iterable<Category> categories) {
        List<CategoryModel> categoryModelList = new ArrayList<>();
        for (Category category: categories)
        {
            categoryModelList.add(CategoryModel.toModel(category));
        }
        return categoryModelList;
    }

    public List<CategoryModel> getAllCategories() {
        return convertCategoryToModel(categoryRepo.findAll());
    }

    public CategoryModel findOneCategory(Integer id) throws NotFoundException {
        Category category = categoryRepo.findById(id).get();
        if (category == null) {
            throw new NotFoundException("Категория не найдена");
        }
        return CategoryModel.toModel(category);
    }

    public int deleteCategory(Integer id) throws NotFoundException {
        if (!categoryRepo.existsById(id)) {
            throw new NotFoundException("Категория не найдена");
        }
        categoryRepo.deleteById(id);
        return id;
    }

    public Category updateCategory(Integer id, Category model) throws NotFoundException {
        if (!categoryRepo.existsById(id)) {
            throw new NotFoundException("Категория не найдена");
        }
        Category category = categoryRepo.findById(id).get();
        category.setName(model.getName());
        category.setDescription(model.getDescription());
        return categoryRepo.save(category);
    }

}
