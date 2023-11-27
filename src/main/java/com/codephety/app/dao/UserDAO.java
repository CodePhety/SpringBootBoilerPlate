package com.codephety.app.dao;

import com.codephety.app.dto.User;

public interface UserDAO {

    void save(User user);

    User findById(int id);

    User update(User user, boolean isFullUpdate);

    void remove(int id);


}
