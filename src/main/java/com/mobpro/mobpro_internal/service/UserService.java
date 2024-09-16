package com.mobpro.mobpro_internal.service;

import com.mobpro.mobpro_internal.dto.UserDTO;
import com.mobpro.mobpro_internal.entity.user.User;
import com.mobpro.mobpro_internal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return new UserDTO(user);
    }

    public void addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User user = new User(userDTO);
        assert userRepository.findById(user.getId()) != null;
        userRepository.save(user);
        return new UserDTO(user);
    }

    public void deleteUser(Long id) {
        assert userRepository.findById(id) != null;
        userRepository.deleteById(id);
    }
}
