package com.keepintouch.main.service;

import com.keepintouch.main.model.dto.UserDto;
import com.keepintouch.main.model.entity.User;
import com.keepintouch.main.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private ModelMapper modelMapper = new ModelMapper();
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserDto register(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return modelMapper.map(userRepository.saveAndFlush(user),UserDto.class);
    }

}
