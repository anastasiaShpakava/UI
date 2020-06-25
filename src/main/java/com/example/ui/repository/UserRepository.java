package com.example.ui.repository;

import com.example.ui.model.Status;
import com.example.ui.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shpakova A.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    User findByUserNameAndStatus(String userName, Status status);
}
