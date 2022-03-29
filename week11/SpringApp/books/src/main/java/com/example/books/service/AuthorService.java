package com.example.books.service;

import com.example.books.entity.Authors;
import com.example.books.excepetion.NotFoundException;
import com.example.books.model.AuthorModel;
import com.example.books.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService implements Crud<Authors,AuthorModel,Integer>{
    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public void add(Authors authors) {
        authorRepo.save(authors);
    }

    @Override
    public List<AuthorModel> convertToModel(Iterable<Authors> authors) {
        List<AuthorModel> authorModelList = new ArrayList<>();
        for (Authors author : authors)
        {
            authorModelList.add(AuthorModel.toModel(author));
        }
        return authorModelList;
    }

    @Override
    public List<AuthorModel> getAll() throws NotFoundException {
        return convertToModel(authorRepo.findAll());
    }

    @Override
    public AuthorModel findById(Integer id) throws NotFoundException {
        Authors author = authorRepo.findById(id).get();
        if (!authorRepo.existsById(id)) {
            throw new NotFoundException("Автор не найден");
        }
        return AuthorModel.toModel(author);
    }

    @Override
    public int deleteById(Integer id) throws NotFoundException {
        if (!authorRepo.existsById(id)) {
            throw new NotFoundException("Автор не найден");
        }
        authorRepo.deleteById(id);
        return id;
    }

    @Override
    public Authors updateEntity(Integer id, Authors authorModel) throws NotFoundException {
        if (!authorRepo.existsById(id)) {
            throw new NotFoundException("Автор не найден");
        }
        Authors author = authorRepo.findById(id).get();
        author.setFirstName(authorModel.getFirstName());
        author.setLastName(authorModel.getLastName());
        return authorRepo.save(author);
    }
}
