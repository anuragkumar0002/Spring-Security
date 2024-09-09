package com.jwtAuthEx.jwtPrac.service;

import com.jwtAuthEx.jwtPrac.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    Integer saveUser(User user);
    User findByUsername(String username);
}
