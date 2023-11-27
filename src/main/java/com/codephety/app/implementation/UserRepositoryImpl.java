package com.codephety.app.implementation;

import com.codephety.app.dto.User;
import com.codephety.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
public abstract class UserServiceImpl implements UserRepository {

    @Autowired
    private UserRepository userRepository;

    // Save operation
    @Override
    public User saveUser(User User) { return userRepository.save(User); }

    // Read operation
    @Override
    public List<User> fetchUserList() { return userRepository.findAll(); }

    public User fetchUserById(Long userId) { return userRepository.findById(userId).get(); }


    // Delete operation
    //@Override
    public void deleteUserById(Long UserId) { userRepository.deleteById(UserId); }

    // Update operation
    //@Override
    public User updateUser(User user, Long userId) {

        User depDB = userRepository.findById(userId).get();

        if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase( user.getFirstName())) {
            depDB.setFirstName(user.getFirstName());
        }

        if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
            depDB.setLastName(user.getLastName());
        }

//        if (Objects.nonNull(user.getUserCode()) && !"".equalsIgnoreCase(user.getUserCode())) {
//            depDB.setUserCode(user.getUserCode());
//        }

        return userRepository.save(depDB);
    }

}
