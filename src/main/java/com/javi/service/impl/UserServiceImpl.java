package com.javi.service.impl;

import com.javi.entity.User;
import com.javi.repository.UserRepository;
import com.javi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, Long>  implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        super.setRepository(userRepository);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void create(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
