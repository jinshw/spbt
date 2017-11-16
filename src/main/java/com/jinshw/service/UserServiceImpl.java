package com.jinshw.service;

import com.jinshw.mapper.UserMapper;
import com.jinshw.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    public User getUserById(int id) {
        return mapper.getUserById(id);
    }
}
