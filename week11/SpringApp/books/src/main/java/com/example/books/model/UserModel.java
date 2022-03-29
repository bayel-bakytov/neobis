package com.example.books.model;

import com.example.books.entity.Authors;
import com.example.books.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {
    private String firstName;
    private String password;

    public static UserModel toModel(User user) {
        UserModel authorModel = new UserModel();
        authorModel.setFirstName(user.getFirstName());
        authorModel.setPassword(user.getPassword());
        return authorModel;
    }

}
