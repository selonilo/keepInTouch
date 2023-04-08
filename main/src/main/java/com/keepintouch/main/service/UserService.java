package com.keepintouch.main.service;

import com.keepintouch.main.model.dto.UserDto;
import com.keepintouch.main.model.entity.User;
import com.keepintouch.main.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserRepository userRepository;

    public UserDto register(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.saveAndFlush(user),UserDto.class);
    }

}
