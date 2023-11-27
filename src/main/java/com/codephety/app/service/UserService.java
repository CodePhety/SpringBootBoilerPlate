package com.codephety.app.service;

import com.codephety.app.dao.UserDAOImpl;
import com.codephety.app.dto.User;
import com.codephety.app.implementation.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
//@Scope(value = "session")
@Component
public class UserService {

    @Autowired
    public UserDAOImpl userDAOImpl;

    //Fetches and existing user
    public User fetchUser(int id) { return userDAOImpl.findById(id); }

    //Create a new user object
    public void createUser(User user) { userDAOImpl.save(user); }

    //Updates and existing user
    public User updateUser(User user) { return userDAOImpl.update(user, false); }

    //Replaces an existing user
    public User replaceUser(User user) { return userDAOImpl.update(user, true); }

    //Deletes User
    public void removeUser(int id) { userDAOImpl.remove(id); }
}
