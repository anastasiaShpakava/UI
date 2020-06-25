package com.example.ui.service;


import com.example.ui.exception.ResourceNotFoundException;
import com.example.ui.model.Status;
import com.example.ui.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Shpakova A.
 */

public interface UserService {
    void save(User user);

    // void saveNewUserAccount(CreateUserAccountDto userAccountDto);

    //void updateUserAccount(UpdateUserAccountDto userAccountDto);

    void changeStatus(Integer id, Status status);

    User findByUserName(String userName);

    User findById(Integer id);

    List<User> findAll();

    Page<User> findAllPagination(Pageable pageable);
}
