package com.javi.service;

import com.javi.entity.User;

public interface UserService extends CommonService<User, Long> {
    User findByEmail(String email);
}
