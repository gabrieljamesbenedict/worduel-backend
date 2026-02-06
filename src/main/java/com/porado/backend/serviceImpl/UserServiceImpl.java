package com.porado.backend.serviceImpl;

import com.porado.backend.exception.UserAlreadyExistsException;
import com.porado.backend.exception.UserNotFoundException;
import com.porado.backend.model.User;
import com.porado.backend.repository.UserRepository;
import com.porado.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user with Id="+id));
    }

    @Override
    public User createUser(User user) {
        if (userRepository.existsById(user.getUserId())) throw new UserAlreadyExistsException("User already exists");
        else if (user.getUserId() != null) throw new IllegalArgumentException("User must have null Id on creation");
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User oldUser = getUserById(id);
        BeanUtils.copyProperties(user, oldUser, "userId");
        return userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(Long id) {
        User oldUser = getUserById(id);
        userRepository.delete(oldUser);
    }
}
