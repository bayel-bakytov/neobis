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
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    public Authors addAuthor(Authors authors) {
        return authorRepo.save(authors);
    }

    public List<AuthorModel> convertAuthorToModel(Iterable<Authors> authors) {
        List<AuthorModel> authorModelList = new ArrayList<>();
        for (Authors author : authors)
        {
            authorModelList.add(AuthorModel.toModel(author));
        }
        return authorModelList;
    }

    public List<AuthorModel> getAllAuthors() {
        return convertAuthorToModel(authorRepo.findAll());
    }

    public AuthorModel findOneAuthor(Integer id) throws NotFoundException {
        Authors author = authorRepo.findById(id).get();
        if (author == null) {
            throw new NotFoundException("Автор не найден");
        }
        return AuthorModel.toModel(author);
    }

    public int deleteAuthor(Integer id) throws NotFoundException {
        if (!authorRepo.existsById(id)) {
            throw new NotFoundException("Автор не найден");
        }
        authorRepo.deleteById(id);
        return id;
    }

    public Authors updateAuthor(Integer id, Authors model) throws NotFoundException {
        if (!authorRepo.existsById(id)) {
            throw new NotFoundException("Автор не найден");
        }
        Authors author = authorRepo.findById(id).get();
        author.setFirstName(model.getFirstName());
        author.setLastName(model.getLastName());
        return authorRepo.save(author);
    }

}
