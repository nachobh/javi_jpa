package com.javi.service.impl;

import com.javi.entity.Role;
import com.javi.repository.RoleRepository;
import com.javi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Role, Long> implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl() {
        super.setRepository(roleRepository);
    }
}
