package com.codephety.app.dao;

import com.codephety.app.dto.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {
    //Define an entity manager
    private EntityManager entityManager;

    //Inject entity manager using constructor injection
    @Autowired
    public UserDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //implement save
    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(int id) { return entityManager.find(User.class, id); }

    @Override
    @Transactional
    public User update(User userUpdate, boolean isFullUpdate) {
        User currentUser = new User();
        //Find the current user
        if(!isFullUpdate) {
            currentUser = entityManager.find(User.class, userUpdate.getId());
        }
        //Update
        currentUser.setLastName(userUpdate.getLastName());
        currentUser.setFirstName(userUpdate.getFirstName());
        entityManager.merge(userUpdate);
        return entityManager.find(User.class, userUpdate.getId());
    }

    @Override
    @Transactional
    public void remove(int id) {
        //Find the current user
        User user = entityManager.find(User.class, id);
        //Remove user with matching ID
        entityManager.remove(user);
    }

}
