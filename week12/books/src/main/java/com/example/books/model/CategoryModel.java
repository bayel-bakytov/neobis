package com.example.books.model;

import com.example.books.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryModel {
    private Integer genreId;
    private String name;
    private String description;

    public CategoryModel() {}

    public static CategoryModel toModel(Category category) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setGenreId(category.getGenreId());
        categoryModel.setName(category.getName());
        categoryModel.setDescription(category.getDescription());
        return categoryModel;
    }

    public CategoryModel(Integer genreId, String name, String description) {
        this.genreId = genreId;
        this.name = name;
        this.description = description;
    }
}
