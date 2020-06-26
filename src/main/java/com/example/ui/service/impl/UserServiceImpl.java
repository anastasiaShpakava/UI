package com.example.ui.service.impl;

import com.example.ui.exception.ResourceNotFoundException;
import com.example.ui.model.Status;
import com.example.ui.model.dto.CustomUserDetails;
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
        Optional<User> userFromDb = userRepository.findById(id);
        if (userFromDb.isPresent()) {
            userFromDb.get().setStatus(status);
            save(userFromDb.get());
        } else {
            throw new ResourceNotFoundException("User with such id is not found");
        }
    }

    @SneakyThrows
    @Override
    public User findByUserName(String userName) {
        Optional<User> userFromDb = Optional.ofNullable(userRepository.findByUserName(userName));
        return Optional.of(userFromDb).get().orElseThrow(() -> new ResourceNotFoundException("User with such login is not found!"));

    }

    @SneakyThrows
    @Override
    public User findById(Integer id) {
        Optional<User> userFromDb = userRepository.findById(id);
        return Optional.of(userFromDb).get().orElseThrow(() -> new ResourceNotFoundException("User with such login is not found!"));
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAllPagination(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(userName);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}
