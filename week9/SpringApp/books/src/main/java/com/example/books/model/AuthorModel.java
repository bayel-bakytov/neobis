package com.example.books.model;

import com.example.books.entity.Authors;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorModel {
    private Integer authorId;
    private String firstName;
    private String lastName;

    public AuthorModel() {}

    public static AuthorModel toModel(Authors author) {
        AuthorModel authorModel = new AuthorModel();
        authorModel.setAuthorId(author.getAuthorId());
        authorModel.setFirstName(author.getFirstName());
        authorModel.setLastName(author.getLastName());
        return authorModel;
    }

    public AuthorModel(Integer authorId, String firstName, String lastName) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
