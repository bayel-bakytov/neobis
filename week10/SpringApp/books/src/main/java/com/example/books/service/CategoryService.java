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
public class CategoryService implements Crud<Category,CategoryModel,Integer>{
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public void add(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public List<CategoryModel> convertToModel(Iterable<Category> categories) {
        List<CategoryModel> categoryModelList = new ArrayList<>();
        for (Category category: categories)
        {
            categoryModelList.add(CategoryModel.toModel(category));
        }
        return categoryModelList;
    }

    @Override
    public List<CategoryModel> getAll() throws NotFoundException {
        return convertToModel(categoryRepo.findAll());
    }

    @Override
    public CategoryModel findById(Integer id) throws NotFoundException {
        Category category = categoryRepo.findById(id).get();
        if (category == null) {
            throw new NotFoundException("Категория не найдена");
        }
        return CategoryModel.toModel(category);
    }

    @Override
    public int deleteById(Integer id) throws NotFoundException {
        if (!categoryRepo.existsById(id)) {
            throw new NotFoundException("Категория не найдена");
        }
        categoryRepo.deleteById(id);
        return id;    }

    @Override
    public Category updateEntity(Integer id, Category categoryChange) throws NotFoundException {
        if (!categoryRepo.existsById(id)) {
            throw new NotFoundException("Категория не найдена");
        }
        Category category = categoryRepo.findById(id).get();
        category.setName(categoryChange.getName());
        category.setDescription(categoryChange.getDescription());
        return categoryRepo.save(category);
    }
}
