package com.example.books.service;

import com.example.books.excepetion.NotFoundException;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface Crud <Entity, Model, Integer>{
    void add(Entity entity);
    List<Model> convertToModel(Iterable<Entity> entities);
    List<Model> getAll() throws NotFoundException;
    Model findById(Integer id) throws NotFoundException;
    int deleteById(Integer id) throws NotFoundException;
    Entity updateEntity(Integer id, Entity entityChange) throws NotFoundException;
}
