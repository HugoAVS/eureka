package com.jeoldev.userinfo.service;

import com.jeoldev.userinfo.dto.UserDTO;
import com.jeoldev.userinfo.entity.User;
import com.jeoldev.userinfo.mapper.UserMapper;
import com.jeoldev.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;
    
    public UserDTO addUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.mapUserDTOToUser(userDTO);
        User savedUser = userRepo.save(user);
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }
    
    public UserDTO fetchUserDetailsById(Long userId) {
        Optional<User> fetchedUser = userRepo.findById(userId);
        return fetchedUser.map(UserMapper.INSTANCE::mapUserToUserDTO).orElse(null);
    }
}