package com.example.ui.service.impl;

import com.example.ui.exception.ResourceNotFoundException;
import com.example.ui.model.Status;
import com.example.ui.model.entity.User;
import com.example.ui.repository.UserRepository;
import com.example.ui.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Shpakova A.
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @SneakyThrows
    @Override
    public void changeStatus(Integer id, Status status) {
Optional<User> userFromDB=userRepository.findById(id);
        if (userFromDB.isPresent()){
            userFromDB.get().setStatus(status);
            save(userFromDB.get());
        } else {
            throw new ResourceNotFoundException("User with such id is not found");
        }
    }

    @Override
    public User findByUserName(String userName) {
       Optional<User> userFromDb= Optional.ofNullable(userRepository.findByUserName(userName));
       if (userFromDb.isPresent()){
          userFromDb.get();
       }
       return userFromDb.get();
    }

    @Override
    public User findById(Integer id) {
        return null;
    }


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Page<User> findAllPagination(Pageable pageable) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
